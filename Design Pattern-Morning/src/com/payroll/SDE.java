package com.payroll;

public class SDE extends Employee {
    public SDE(int id, String name, String email, String designation, double salary, String notificationMode) {
        setId(id);
        setName(name);
        setEmail(email);
        setDesignation(designation);
        setSalary(salary);
        setNofificationMode(notificationMode);
    }
}
