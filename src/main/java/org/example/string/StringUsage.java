package org.example.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringUsage {
    private static String uppercase(String str) {
        return str.toUpperCase();
    }
    private static String lowercase(String str) {
        return str.toLowerCase();
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
