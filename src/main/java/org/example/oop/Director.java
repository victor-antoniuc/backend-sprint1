package org.example.oop;

public class Director extends Employee {
    private final String companyName;

    public Director(Integer personalCode, String firstLastName, Integer positionCode, String companyName, Integer salary) {
        super(personalCode, firstLastName, positionCode, salary);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
