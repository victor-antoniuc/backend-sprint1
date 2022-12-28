package org.example.oop;

import org.example.collections.CollectionsUsage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Employees {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> employess = Files.readAllLines(Paths.get(CollectionsUsage.class.getResource("/employee-opp-input.txt").toURI()));


    }
}
