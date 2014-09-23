package com.techidiocy.models.destination;

import com.techidiocy.annotation.Relation;

@Relation(associatedSourceClass=com.techidiocy.models.source.Employer.class)
public class EmployerDTO extends BaseDTO {

	private String employerName;
	private AddressDTO employerAddress;
	private int noOfEmployees;
	
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public AddressDTO getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(AddressDTO employerAddress) {
		this.employerAddress = employerAddress;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	
	
}
