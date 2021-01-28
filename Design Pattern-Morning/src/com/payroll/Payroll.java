package com.payroll;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Payroll {
    public static void main(String [] args) {
        List<Employee> employeeList = new ArrayList<>();

        EmployeeFactory factory = new EmployeeFactory();

        employeeList.add(factory.createEmployee(1,"XYZ","test1@test.com","Manager",50000,"SMS"));
        employeeList.add(factory.createEmployee(2,"ABC","test2@test.com","SDE",60000,"Email"));
        employeeList.add(factory.createEmployee(3,"DEF","test3@test.com","HR",50000,"SMS"));
        employeeList.add(factory.createEmployee(4,"GHI","test4@test.com","HR",50000,"SMS"));
        employeeList.add(factory.createEmployee(5,"JKL","test5@test.com","Trainee",20000,"Email"));
        employeeList.add(factory.createEmployee(6,"MNO","test6@test.com","SDE",50000,"Email"));
        employeeList.add(factory.createEmployee(7,"PQR","test7@test.com","Trainee",20000,"SMS"));
        employeeList.add(factory.createEmployee(8,"STU","test8@test.com","Manager",50000,"Email"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime today = LocalDateTime.now();

        if(today.getDayOfMonth() == 15 && today.getHour() == 15 &&
                today.getMinute() == 0 && today.getSecond() == 0)
        {
            for(Employee emp : employeeList) {
                emp.notifyEmployee();
            }
        }
    }
}
