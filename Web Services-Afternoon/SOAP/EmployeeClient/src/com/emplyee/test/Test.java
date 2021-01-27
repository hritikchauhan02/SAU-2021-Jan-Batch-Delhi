package com.emplyee.test;

import com.employee.EmployeeImpl;
import com.employee.EmployeeImplService;

public class Test {
	public static void main(String [] args) {
		EmployeeImplService wsdl = new EmployeeImplService();
		EmployeeImpl service = wsdl.getEmployeeImpl();
		service.setId("1");
		service.setName("Hritik Chauhan");
		service.setAge(22);
		service.setEmail("test@test.com");
		service.setAddress("XYZ");
		
		System.out.println(
				service.getId() + " "
				+ service.getName() + " "
				+ service.getEmail() + " "
				+ service.getAge() + " "
				+ service.getAddress()
				);
	}

}
