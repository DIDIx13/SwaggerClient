package ch.heg.ig.client;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner;

    public UserInteraction() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
