package com.payroll;

public class EmployeeFactory {
    public static Employee createEmployee(int id,  String name, String email, String designation, double salary, String notificationMode) {

        switch (designation) {
            case "SDE":
                return new SDE(id,name,email,designation,salary,notificationMode);

            case "HR":
                return new HR(id,name,email,designation,salary,notificationMode);

            case "Manager":
                return new Manager(id,name,email,designation,salary,notificationMode);

            case "Trainee":
                return new Trainee(id,name,email,designation,salary,notificationMode);

            default:
                return null;
        }
    }
}
