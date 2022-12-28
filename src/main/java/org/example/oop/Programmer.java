package org.example.oop;

public class Programmer extends Employee {
    String programmingLanguage;
    public Programmer(String personalCode, String firstLastName, String positionCode, String programmingLanguage, int salary) {
        super(personalCode, firstLastName, positionCode, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
