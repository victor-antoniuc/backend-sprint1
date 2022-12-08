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
        int vow = 0, con = 0;

        String ref = "aeiouAEIOU";

        for (int i=0; i< string.length(); i++) {
            if ((string.charAt(i) >= 'A'
                    && string.charAt(i) <= 'Z')
                    || (string.charAt(i) >= 'a'
                    && string.charAt(i) <= 'z')) {
                if (ref.indexOf(string.charAt(i)) != -1)
                    vow++;
                else
                    con++;
            }
        }
        System.out.println("Number of Vowels = " + vow + "\nNumber of Consonants = " + con);
        return vow;
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

        for (int i=0; i<words.length; i++) {
            if (small.length() > words[i].length()) {
                small = words[i];
            }

            if (large.length() < words[i].length()) {
                large = words[i];
            }
        }
        System.out.println("Smallest word: " + small);
        System.out.println("Largest word: " + large);
        return string;
    }

    public static void main(String[] args) throws IOException {
        Path input = Path.of("/home/libre_alex/projects/internship/backend-sprint1-fix/src/main/resources/input.txt");
        String input_str = Files.readString(input);
        System.out.println(input_str);

        try {
            FileWriter myWriter = new FileWriter("/home/libre_alex/projects/internship/backend-sprint1-fix/src/main/resources/output.txt");
            myWriter.write(uppercase(input_str));
            myWriter.write(lowercase(input_str));
            myWriter.write(lengthString(input_str));
            myWriter.write(vowelsAndConsonants(input_str));
            myWriter.write(numberOfWords(input_str));
            myWriter.write(duplicate(input_str));
            myWriter.write(largestAndSmallestWord(input_str));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Path output = Path.of("/home/libre_alex/projects/internship/backend-sprint1-fix/src/main/resources/output.txt");
        String output_str = Files.readString(output);
        System.out.println(output_str);
    }
}
