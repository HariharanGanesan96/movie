package com.model;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private Date dobDate;
	private Date dojDate;
	private String email;
	private long employeenumber;
	private int employeesalary;
	private Date regDate;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDobDate() {
		return dobDate;
	}
	public void setDobDate(Date dobDate) {
		this.dobDate = dobDate;
	}
	public Date getDojDate() {
		return dojDate;
	}
	public void setDojDate(Date dojDate) {
		this.dojDate = dojDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getEmployeenumber() {
		return employeenumber;
	}
	public void setEmployeenumber(long employeenumber) {
		this.employeenumber = employeenumber;
	}
	public int getEmployeesalary() {
		return employeesalary;
	}
	public void setEmployeesalary(int employeesalary) {
		this.employeesalary = employeesalary;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dobDate, dojDate, email, employeeId, employeenumber, employeesalary, firstName, lastName,
				regDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dobDate, other.dobDate) && Objects.equals(dojDate, other.dojDate)
				&& Objects.equals(email, other.email) && employeeId == other.employeeId
				&& employeenumber == other.employeenumber && employeesalary == other.employeesalary
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(regDate, other.regDate);
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dobDate=" + dobDate + ", dojDate=" + dojDate + ", email=" + email + ", employeenumber="
				+ employeenumber + ", employeesalary=" + employeesalary + ", regDate=" + regDate + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, Date dobDate) {
		super();
		this.employeeId = employeeId;
		this.dobDate = dobDate;
	}
	public Employee(int employeeId, String firstName, String lastName, Date dobDate, Date dojDate, String email,
			long employeenumber, int employeesalary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dobDate = dobDate;
		this.dojDate = dojDate;
		this.email = email;
		this.employeenumber = employeenumber;
		this.employeesalary = employeesalary;
	}
	public Employee(int employeeId, String firstName, String lastName, Date dobDate, Date dojDate, String email,
			long employeenumber, int employeesalary, Date regDate) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dobDate = dobDate;
		this.dojDate = dojDate;
		this.email = email;
		this.employeenumber = employeenumber;
		this.employeesalary = employeesalary;
		this.regDate = regDate;
	}
	

}
