package com.payroll;

public class HR extends Employee {
    public HR(int id, String name, String email, String designation, double salary, String notificationMode) {
        setId(id);
        setName(name);
        setEmail(email);
        setDesignation(designation);
        setSalary(salary);
        setNofificationMode(notificationMode);
    }
}
