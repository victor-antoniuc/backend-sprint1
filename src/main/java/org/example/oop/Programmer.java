package org.example.oop;

public class Programmer extends Employee {
    private final String programmingLanguage;
    public Programmer(Integer personalCode, String firstLastName, Integer positionCode, String programmingLanguage, Integer salary) {
        super(personalCode, firstLastName, positionCode, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}
