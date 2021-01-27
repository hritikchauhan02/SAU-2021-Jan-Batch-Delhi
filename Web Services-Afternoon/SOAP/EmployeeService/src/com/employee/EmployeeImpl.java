package com.employee;

public class EmployeeImpl implements Employee {
	
	private String id;
	private String name;
	private int age;
	private String email;
	private String address;

	@Override
	public void setId(String id) {
		this.id = id;

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;

	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;

	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

}
