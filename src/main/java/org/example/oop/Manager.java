package org.example.oop;

public class Manager extends Employee {
    private final String numberOfEmployees;
    public Manager(Integer personalCode, String firstLastName, Integer positionCode, String numberOfEmployees, Integer salary) {
        super(personalCode, firstLastName, positionCode, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
