package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController

public class EmployeeController {

	@Autowired
    EmployeeRepository employeeRepository;
	
//	Add new Employee to the database
	@PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

// Search All Employee based on his location and pincode
	
	@GetMapping("/employee/location/{location}/pincode/{pincode}")
    public List<Employee> getEmployeeByLocationAndPincode(@PathVariable String location, @PathVariable String pincode) {
        return (List<Employee>) employeeRepository.findByLocationAndPincode(location, pincode);
	}
}
