package ch.heg.ig.client;

import ch.heg.ig.model.Document;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiClient {
    final private String baseUrl = "http://157.26.83.80:2240/api";
    final private HttpClient client;
    final private String token;
    final private ObjectMapper objectMapper;

    public ApiClient(String token) {
        this.client = HttpClient.newHttpClient();
        this.token = token;
        this.objectMapper = new ObjectMapper();
    }

    public String getCurrentUserDetails() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/account/current"))
                .header("Accept", "application/json")
                .header("Authorization", "bearer " + this.token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String validateDocument(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/flow/validate/" + documentId))
                .header("Authorization", "bearer " + this.token)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String refuseDocument(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/flow/refuse/" + documentId))
                .header("Authorization", "bearer " + this.token)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Document getDocumentData(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/document/" + documentId + "/metadata"))
                .header("Accept", "application/json")
                .header("Authorization", "bearer " + this.token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Document.class);
    }

    public byte[] getDocumentPdf(int documentId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/document/" + documentId + "/display"))
                .header("Accept", "application/json")
                .header("Authorization", "bearer " + this.token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String base64File = objectMapper.readTree(response.body()).get("File").asText();
        return java.util.Base64.getDecoder().decode(base64File);
    }
}

