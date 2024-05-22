package ch.heg.ig.client;

import ch.heg.ig.model.Document;
import ch.heg.ig.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ApiClient {
    final private String baseUrl = "http://157.26.83.80:2240";
    final private HttpClient client;
    final private ObjectMapper objectMapper;
    private String token;

    public ApiClient() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public void generateToken(String username, String password) throws IOException, InterruptedException {
        String form = "grant_type=password&username=" + username + "&password=" + password;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(form))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Debugging output to see the response
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        JsonNode jsonNode = objectMapper.readTree(response.body());
        if (jsonNode.has("access_token")) {
            this.token = jsonNode.get("access_token").asText();
        } else {
            throw new IOException("Failed to retrieve access token, response: " + response.body());
        }
    }

    public User getCurrentUserDetails() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/account/current"))
                .header("Accept", "application/json")
                .header("Authorization", "bearer " + this.token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        // Désérialiser l'utilisateur
        return objectMapper.readValue(responseBody, User.class);
    }

    public String validateDocument(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/flow/validate/" + documentId))
                .header("Authorization", "bearer " + this.token)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String refuseDocument(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/flow/refuse/" + documentId))
                .header("Authorization", "bearer " + this.token)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Document getDocumentData(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/document/" + documentId + "/metadata"))
                .header("Accept", "application/json")
                .header("Authorization", "bearer " + this.token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        // Afficher la réponse pour le débogage
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + responseBody);

        // Vérifier si la réponse est une erreur
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        if (jsonNode.has("error") || response.statusCode() != 200) {
            throw new IOException("Error retrieving document data: " + responseBody);
        }

        // Désérialiser le document si aucune erreur
        return objectMapper.readValue(responseBody, Document.class);
    }


    public byte[] getDocumentPdf(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/api/document/" + documentId + "/display"))
                .header("Accept", "application/json")
                .header("Authorization", "bearer " + this.token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String base64File = objectMapper.readTree(response.body()).get("File").asText();
        return java.util.Base64.getDecoder().decode(base64File);
    }
}
