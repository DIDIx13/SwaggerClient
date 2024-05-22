package ch.heg.ig.client;

import ch.heg.ig.model.Document;
import ch.heg.ig.model.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Scanner scanner = new Scanner(System.in);

        try {
            // Menu de sélection de compte pour le débogage
            System.out.println("Select account to use:");
            System.out.println("1. admin.24g1");
            System.out.println("2. sophie.respachat");
            System.out.println("3. sophie.rh");
            System.out.print("Enter choice: ");
            int choice = getIntInput(scanner);

            String username = "";
            String password = "";

            switch (choice) {
                case 1:
                    username = "admin.24g1";
                    password = "14291215410180203107204541779216928182107183129445";
                    break;
                case 2:
                    username = "sophie.respachat";
                    password = "2214168391011018575218174572392097019224510826672";
                    break;
                case 3:
                    username = "sophie.rh";
                    password = "142104190962072521710890237244144197679511625125059174";
                    break;
                default:
                    System.out.println("Invalid choice. Exiting.");
                    System.exit(0);
            }

            // Générer le token
            apiClient.generateToken(username, password);
            System.out.println("Token generated successfully!");

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
                    System.out.print("Enter choice: ");
                    int actionChoice = getIntInput(scanner);

                    if (actionChoice == 6) {
                        System.out.println("Exiting.");
                        break;
                    }

                    int documentId = 0;
                    if (actionChoice > 1 && actionChoice <= 5) {
                        System.out.print("Enter document ID: ");
                        documentId = getIntInput(scanner);
                    }

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
                } catch (IOException | InterruptedException e) {
                    handleException(e);
                }
            }

        } catch (IOException | InterruptedException e) {
            handleException(e);
        } finally {
            scanner.close();
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static void handleException(Exception e) {
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
