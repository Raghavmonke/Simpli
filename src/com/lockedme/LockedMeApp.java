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
        System.out.println("          Made by : Raghav Gupta              ");
        System.out.println("===============================================\n");
        System.out.println("Press Enter to continue...");
        try {
            while (System.in.read() != '\n'); //handling first input 
        } catch (Exception ignored) {}
    }
}
