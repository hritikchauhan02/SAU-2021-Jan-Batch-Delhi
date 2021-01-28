package com.payroll;

public class Manager extends Employee {
    public Manager(int id, String name, String email, String designation, double salary, String notificationMode) {
        setId(id);
        setName(name);
        setEmail(email);
        setDesignation(designation);
        setSalary(salary);
        setNofificationMode(notificationMode);
    }
}
