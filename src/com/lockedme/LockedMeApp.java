package com.lockedme;
import java.util.Scanner;

public class LockedMeApp {

    public static final String ROOT_DIRECTORY = "rootDir"; // Default directory path

    public static void main(String[] args) {
        printWelcomeScreen();
        Scanner scanner = new Scanner(System.in);
        MenuHandler.displayMainMenu(scanner);
        scanner.close();
    }

    private static void printWelcomeScreen() {
        System.out.println("===============================================");
        System.out.println("         Welcome to LockedMe.com              ");
        System.out.println("     A CLI-based file management system       ");
        System.out.println("===============================================\n");
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignore minor exceptions
        }
    }
}
