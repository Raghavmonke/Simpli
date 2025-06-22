package com.lockedme;
import java.util.Scanner;

public class MenuHandler {

    public static void displayMainMenu(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display all files in ascending order");
            System.out.println("2. Business operations (Coming in Sprint 2)");
            System.out.println("3. Exit application");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            switch (choice) {
                case 1:
                    FileManager.displayFiles(LockedMeApp.ROOT_DIRECTORY);
                    break;
                case 2:
                    System.out.println("Business operations are not yet implemented.");
                    break;
                case 3:
                    System.out.println("Thank you for using LockedMe.com. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
