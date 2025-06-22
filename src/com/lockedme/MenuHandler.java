package com.lockedme;

import java.util.Scanner;

public class MenuHandler {


    public static void displayMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display all files in ascending order");
            System.out.println("2. Business operations");
            System.out.println("3. Exit application");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    FileManager.displayFiles(LockedMeApp.ROOT_DIRECTORY);
                    break;
                case "2":
                    displayBusinessMenu(scanner);
                    break;
                case "3":
                    System.out.println("Thank you for using LockedMe.com. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }
    }


    private static void displayBusinessMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nBusiness Operations:");
            System.out.println("a. Add a file");
            System.out.println("b. Delete a file");
            System.out.println("c. Search for a file");
            System.out.println("d. Return to Main Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "a":
                    System.out.print("Enter the file name to add: ");
                    FileManager.addFile(LockedMeApp.ROOT_DIRECTORY, scanner.nextLine().trim());
                    break;
                case "b":
                    System.out.print("Enter the exact file name to delete: ");
                    FileManager.deleteFile(LockedMeApp.ROOT_DIRECTORY, scanner.nextLine().trim());
                    break;
                case "c":
                    System.out.print("Enter the file name to search: ");
                    FileManager.searchFile(LockedMeApp.ROOT_DIRECTORY, scanner.nextLine().trim());
                    break;
                case "d":
                    return; // back to main menu
                default:
                    System.out.println("Invalid option. Please enter a, b, c, or d.");
            }
        }
    }
}
