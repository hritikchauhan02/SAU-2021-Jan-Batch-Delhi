package com.payroll;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String designation;
    private double salary;
    private String nofificationMode;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNofificationMode(String nofificationMode) {
        this.nofificationMode = nofificationMode;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNofificationMode() {
        return nofificationMode;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public void notifyEmployee()
    {
        if(nofificationMode.equals("SMS")) {
            System.out.println(
                    "Send SMS Notification to" +
                            " id : " + id +
                            " name : " + name +
                            " designation : " + designation +
                            " email : " + email +
                            " salary : " + salary
            );
        } else {
            System.out.println(
                    "Send Email Notification to" +
                            " id : " + id +
                            " name : " + name +
                            " designation : " + designation +
                            " email : " + email +
                            " salary : " + salary
            );
        }
    }
}
