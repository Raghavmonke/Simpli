package com.lockedme;
import java.io.File;
import java.util.Arrays;

public class FileManager {

    public static void displayFiles(String directoryPath) {
        File folder = new File(directoryPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Root directory does not exist. Please create a folder named 'rootDir'.");
            return;
        }

        String[] files = folder.list();

        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }

        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER); // Sorting ascending, case-insensitive
        System.out.println("\nFiles in '" + directoryPath + "' in ascending order:");
        for (String file : files) {
            System.out.println("- " + file);
        }
    }
}
