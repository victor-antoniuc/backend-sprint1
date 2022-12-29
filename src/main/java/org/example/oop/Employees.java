package org.example.oop;

import org.example.collections.CollectionsUsage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employees {
    private static List<Employee> getEmployees (List<String> string) {
        List<Employee> employees = new ArrayList<>();

        for (String employee : string) {
            String[] employeeElements = employee.split("\\|");

            if (employeeElements[2].equals("1")) {
                employees.add(new Director(Integer.valueOf(employeeElements[0]), employeeElements[1], Integer.valueOf(employeeElements[2]), employeeElements[3], Integer.valueOf(employeeElements[4])));
            } else if (employeeElements[2].equals("2")) {
                employees.add(new Programmer(Integer.valueOf(employeeElements[0]), employeeElements[1], Integer.valueOf(employeeElements[2]), employeeElements[3], Integer.valueOf(employeeElements[4])));
            } else {
                employees.add(new Manager(Integer.valueOf(employeeElements[0]), employeeElements[1], Integer.valueOf(employeeElements[2]), employeeElements[3], Integer.valueOf(employeeElements[4])));
            }
        }
        return employees;
    }

    private static int getTheTotalAmountOfMoney (List<Employee> employeeList) {
        int result = 0;

        for (Employee employee : employeeList) {
            result += employee.getSalary();
        }

        return result;
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> stringWithEmployees = Files.readAllLines(Paths.get(CollectionsUsage.class.getResource("/employee-opp-input.txt").toURI()));
        stringWithEmployees.sort(String::compareTo);

        List<Employee> employeeList = getEmployees(stringWithEmployees);


    }
}
