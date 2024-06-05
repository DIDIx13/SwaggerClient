package ch.heg.ig.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        UserInteraction userInteraction = new UserInteraction();

        try {
            // Menu de sélection de compte pour le débogage
            System.out.println("Select account to use:");
            System.out.println("1. admin.24g1");
            System.out.println("2. sophie.respachat");
            System.out.println("3. sophie.rh");
            int choice = userInteraction.getIntInput("Enter choice: ");

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

            // Afficher le menu
            AppMenu appMenu = new AppMenu(apiClient, userInteraction);
            appMenu.displayMenu();

        } catch (IOException | InterruptedException e) {
            System.err.println("An unexpected error occurred during the initialization: " + e.getMessage());
        } finally {
            userInteraction.closeScanner();
        }
    }
}
