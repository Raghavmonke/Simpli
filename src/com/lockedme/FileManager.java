package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileManager {


    // 1. Display files
    public static void displayFiles(String directoryPath) {
        File folder = new File(directoryPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Root directory does not exist. Please create the folder: " + directoryPath);
            return;
        }

        String[] files = folder.list();
        if (files == null || files.length == 0) {
            System.out.println("No files found");
            return;
        }

        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        System.out.println("\nFiles in '" + directoryPath + "' (ascending ):");
        for (String f : files) {
            System.out.println("- " + f);
        }
    }

    // 2. Add file (case-insensitive duplicate check)
    public static void addFile(String directoryPath, String fileName) {
        File folder = ensureRoot(directoryPath);
        if (folder == null) return;

        if (containsIgnoreCase(folder, fileName)) {
            System.out.println("A file with the same name already exists. Add operation aborted.");
            return;
        }

        File newFile = new File(folder, fileName);
        try {
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("File '" + fileName + "' added successfully.");
            } else {
                // Shouldn’t hit this because of prior check, but handle just in case
                System.out.println("File could not be created (unknown reason).");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // 3. Delete file (case-insensitive)
    public static void deleteFile(String directoryPath, String fileName) {
        File folder = ensureRoot(directoryPath);
        if (folder == null) return;

        File target = getFileIgnoreCase(folder, fileName);
        if (target == null) {
            System.out.println("File not found (match failed).");
            return;
        }

        if (target.delete()) {
            System.out.println("File '" + target.getName() + "' deleted successfully.");
        } else {
            System.out.println("Unable to delete the file (check permissions).");
        }
    }

    // 4. Search file (case-insensitive)
    public static void searchFile(String directoryPath, String fileName) {
        File folder = ensureRoot(directoryPath);
        if (folder == null) return;

        File match = getFileIgnoreCase(folder, fileName);
        if (match != null) {
            System.out.println("File found: " + match.getName());
        } else {
            System.out.println("File not found in the directory.");
        }
    }


    // Ensuring directory exists; creating if missing
    private static File ensureRoot(String directoryPath) {
        File folder = new File(directoryPath);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Root directory missing; created new folder: " + directoryPath);
            } else {
                System.out.println("Cannot create root directory. Check write permissions.");
                return null;
            }
        }
        return folder;
    }

    // Case-insensitive containment check
    private static boolean containsIgnoreCase(File folder, String fileName) {
        return getFileIgnoreCase(folder, fileName) != null;
    }

    // Return File object whose name matches, ignoring case; else null
    private static File getFileIgnoreCase(File folder, String fileName) {
        String[] files = folder.list();
        if (files == null) return null;
        for (String existing : files) {
            if (existing.equalsIgnoreCase(fileName)) {
                return new File(folder, existing);
            }
        }
        return null;
    }
}
