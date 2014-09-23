package com.techidiocy.models.source;

public class Employer {

	private String employerName;
	private Address employerAddress;
	private int noOfEmployees;
	
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public Address getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(Address employerAddress) {
		this.employerAddress = employerAddress;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	
	
}
