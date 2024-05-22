package ch.heg.ig.client;

import ch.heg.ig.model.Document;
import ch.heg.ig.model.User;

import java.io.IOException;

public class AppMenu {
    private final ApiClient apiClient;
    private final UserInteraction userInteraction;

    public AppMenu(ApiClient apiClient, UserInteraction userInteraction) {
        this.apiClient = apiClient;
        this.userInteraction = userInteraction;
    }

    public void displayMenu() {
        while (true) {
            try {
                // Menu de sélection d'action
                System.out.println("\nSelect action:");
                System.out.println("1. Get current user details");
                System.out.println("2. Get document data");
                System.out.println("3. Get document PDF");
                System.out.println("4. Validate document");
                System.out.println("5. Refuse document");
                System.out.println("6. Exit");
                int actionChoice = userInteraction.getIntInput("Enter choice: ");

                if (actionChoice == 6) {
                    System.out.println("Exiting.");
                    break;
                }

                int documentId = 0;
                if (actionChoice > 1 && actionChoice <= 5) {
                    documentId = userInteraction.getIntInput("Enter document ID: ");
                }

                handleAction(actionChoice, documentId);
            } catch (IOException | InterruptedException e) {
                handleException(e);
            }
        }
    }

    private void handleAction(int actionChoice, int documentId) throws IOException, InterruptedException {
        switch (actionChoice) {
            case 1:
                // Get the current user details
                User userDetails = apiClient.getCurrentUserDetails();
                System.out.println("User Details: " + userDetails);
                break;
            case 2:
                // Get the document data
                Document document = apiClient.getDocumentData(documentId);
                System.out.println("Document Author: " + document.getAuthor());
                break;
            case 3:
                // Get the document as a PDF byte array
                byte[] pdfBytes = apiClient.getDocumentPdf(documentId);
                System.out.println("PDF Size: " + pdfBytes.length);
                break;
            case 4:
                // Validate the document
                String validateResponse = apiClient.validateDocument(documentId);
                System.out.println("Validate Response: " + validateResponse);
                break;
            case 5:
                // Refuse the document
                String refuseResponse = apiClient.refuseDocument(documentId);
                System.out.println("Refuse Response: " + refuseResponse);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private void handleException(Exception e) {
        String message = e.getMessage();
        if (message.contains("access denied")) {
            System.err.println("Error: Access denied. Please check your credentials and try again.");
        } else if (message.contains("document data")) {
            System.err.println("Error: Document not found or access denied. Please check the document ID and try again.");
        } else if (message.contains("Item not found")) {
            System.err.println("Error: Document not found. Please check the document ID and try again.");
        } else {
            System.err.println("An unexpected error occurred: " + message);
        }
    }
}
