package org.example.oop;

public class Employee {
    public String personalCode;
    public String firstLastName;
    public String positionCode;
    public int salary;

    public Employee(String personalCode, String name, String positionCode, int salary) {
        this.personalCode = personalCode;
        this.firstLastName = firstLastName;
        this.positionCode = positionCode;
        this.salary = this.salary;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
