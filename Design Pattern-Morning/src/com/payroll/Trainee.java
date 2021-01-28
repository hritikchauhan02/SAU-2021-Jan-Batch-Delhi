package com.payroll;

public class Trainee extends Employee {
    public Trainee(int id, String name, String email, String designation, double salary, String notificationMode) {
        setId(id);
        setName(name);
        setEmail(email);
        setDesignation(designation);
        setSalary(salary);
        setNofificationMode(notificationMode);
    }
}
