package org.example.oop;

public class Employee {
    private final Integer personalCode;
    private final String firstLastName;
    private final Integer positionCode;
    private Integer salary;

    public Employee(Integer personalCode, String firstLastName, Integer positionCode, Integer salary) {
        this.personalCode = personalCode;
        this.firstLastName = firstLastName;
        this.positionCode = positionCode;
        this.salary = salary;
    }

    public Integer getPersonalCode() {
        return personalCode;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public Integer getPositionCode() {
        return positionCode;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
