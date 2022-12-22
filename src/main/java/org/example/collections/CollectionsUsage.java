package org.example.collections;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionsUsage {
    private static void extractFromArrayListOfEmployeesWithContains (List<String> names) {
        List<String> uniqueNames = new ArrayList<>();
        for (String name : names) {
            String firstName = name.substring(name.indexOf(" "));
            if (!uniqueNames.contains(firstName)) {
                uniqueNames.add(firstName);
            }
        }
        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
        }
    }

    private static void extractFromArrayListOfEmployeesWithHashSet (List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            String firstName = name.substring(name.indexOf(" "));
            uniqueNames.add(firstName);
        }
        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> names = Files.readAllLines(Paths.get(CollectionsUsage.class.getResource("/employee-input.txt").toURI()));
        names.sort(String::compareTo);

        ArrayList<String> namesList = new ArrayList<>();
        for (String name : names) {
            namesList.add(name.replace("|", " "));
        }

        List<String> result = namesList.stream().map(employee -> {
            LocalDate birthDate = LocalDate.ofEpochDay((long) (Math.random() * LocalDate.now().toEpochDay()));

            return MessageFormat.format(
                    "{0}|{1}|{2}",
                    employee,
                    birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    Period.between(birthDate, LocalDate.now()).getYears()
            );
        }).collect(Collectors.toList());


        extractFromArrayListOfEmployeesWithContains(namesList);
        System.out.println("----------------");
        extractFromArrayListOfEmployeesWithHashSet(namesList);
        System.out.println("----------------");

        try {
            FileWriter myWriter = new FileWriter("./src/main/resources/employee-final.txt");
            for (String i : result) {
                myWriter.write(i);
                System.out.println(i);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
