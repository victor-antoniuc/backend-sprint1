package org.example.string;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StringUsage {
    private static String uppercase(String string) {
        return string.toUpperCase();
    }
    private static String lowercase(String string) {
        return string.toLowerCase();
    }

    private static int lengthString(String string) {
        System.out.println("Line length = " + string.length());
        return 0;
    }

    private static int vowelsAndConsonants(String string) {
        int vowels = 0, сonsonants = 0;

        String ref = "aeiouAEIOU";

        for (int i=0; i< string.length(); i++) {
            if ((string.charAt(i) >= 'A'
                    && string.charAt(i) <= 'Z')
                    || (string.charAt(i) >= 'a'
                    && string.charAt(i) <= 'z')) {
                if (ref.indexOf(string.charAt(i)) != -1)
                    vowels++;
                else
                    сonsonants++;
            }
        }
        System.out.println("Number of Vowels = " + vowels + "\nNumber of Consonants = " + сonsonants);
        return vowels;
    }

    private static int numberOfWords(String string) {
        System.out.println("Number of Words = " + string.split("\\s").length);
        return 0;
    }

    private static String duplicate(String string) {
        String[] words = string.split("\\W");
        System.out.println("Dublicate:");

        Map<String, Integer> word_map = new HashMap<>();

        for (String word : words) {
            if (word_map.get(word) != null) {
                word_map.put(word, word_map.get(word) + 1);
            }
            else {
                word_map.put(word, 1);
            }
        }

        Set<String> word_set = word_map.keySet();

        for (String word : word_set) {
            if (word_map.get(word) > 1) {
                System.out.println(word);
            }
        }
        return string;
    }

    private static String largestAndSmallestWord (String string) {
        String[] words = string.split("\\s");
        String small = "", large="";
        small = large = words[0];

        for (String word : words) {
            if (small.length() > word.length()) {
                small = word;
            }

            if (large.length() < word.length()) {
                large = word;
            }
        }
        System.out.println("Smallest word: " + small);
        System.out.println("Largest word: " + large);
        return string;
    }

    public static void main(String[] args) throws IOException {
        Path input = Path.of("/home/libre_alex/projects/internship/backend-sprint1-fix/src/main/resources/input.txt");
        String inputStr = Files.readString(input);
        System.out.println(inputStr);

        try {
            FileWriter myWriter = new FileWriter("/home/libre_alex/projects/internship/backend-sprint1-fix/src/main/resources/output.txt");
            myWriter.write(uppercase(inputStr));
            myWriter.write(lowercase(inputStr));
            myWriter.write(lengthString(inputStr));
            myWriter.write(vowelsAndConsonants(inputStr));
            myWriter.write(numberOfWords(inputStr));
            myWriter.write(duplicate(inputStr));
            myWriter.write(largestAndSmallestWord(inputStr));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Path output = Path.of("/home/libre_alex/projects/internship/backend-sprint1-fix/src/main/resources/output.txt");
        String outputStr = Files.readString(output);
        System.out.println(outputStr);
    }
}
