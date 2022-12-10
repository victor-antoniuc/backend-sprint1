package org.example.collections;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
        System.out.println(names);
        List<Employee> employees = names.stream().map(s -> {
            String[] firstAndLastName = s.split(" ");
            return new Employee(firstAndLastName[0], firstAndLastName[1]);
        }).toList();

        extractFromArrayListOfEmployeesWithContains(names);
        extractFromArrayListOfEmployeesWithHashSet(names);
    }
}
