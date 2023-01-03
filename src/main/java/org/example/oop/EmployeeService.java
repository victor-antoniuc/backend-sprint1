package org.example.oop;

import org.example.collections.CollectionsUsage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private static void displayEmployeeDetails (List<Employee> employeeList, String name) {
        for (Employee employee : employeeList) {
            if (employee.getFirstLastName().equals(name)) {
                if (employee.getClass() == Director.class) {
                    System.out.println(employee.getPersonalCode() + "|" + employee.getFirstLastName() + "|" + employee.getPositionCode() + "|" + ((Director) employee).getCompanyName() + "|" + employee.getSalary());
                } else if (employee.getClass() == Manager.class) {
                    System.out.println(employee.getPersonalCode() + "|" + employee.getFirstLastName() + "|" + employee.getPositionCode() + "|" + ((Manager) employee).getNumberOfEmployees() + "|" + employee.getSalary());
                } else if (employee.getClass() == Programmer.class) {
                    System.out.println(employee.getPersonalCode() + "|" + employee.getFirstLastName() + "|" + employee.getPositionCode() + "|" + ((Programmer) employee).getProgrammingLanguage() + "|" + employee.getSalary());
                } else {
                    System.out.println(name + " is not defined");
                }

            }
        }
    }

    private static void changeEmployeesSalary (List<Employee> employeeList, int personalCode, int salary) {
        for (Employee employee : employeeList) {
            if (employee.getPersonalCode().equals(personalCode)) {
                employee.setSalary(salary);
            }
        }
    }

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

    private static void getTheTotalAmountOfMoneyAndPercent (List<Employee> employeeList) {
        double totalSum = 0;

        for (Employee employee : employeeList) {
            totalSum += employee.getSalary();
        }

        for (Employee employee : employeeList) {
            double percentage = (employee.getSalary() / totalSum) * 100;
            System.out.println(percentage);
        }

        System.out.println(totalSum);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> stringWithEmployees = Files.readAllLines(Paths.get(CollectionsUsage.class.getResource("/employee-opp-input.txt").toURI()));
        List<Employee> employeeList = getEmployees(stringWithEmployees);
        employeeList.sort(Comparator.comparing(Employee::getFirstLastName));

        changeEmployeesSalary(employeeList, 3, 8000);

        getTheTotalAmountOfMoneyAndPercent(employeeList);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select employee");
        String name = scanner.nextLine();

        displayEmployeeDetails(employeeList, name);
    }
}
