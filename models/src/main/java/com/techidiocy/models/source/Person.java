/**
 * 
 */
package com.techidiocy.models.source;

import java.util.List;

/**
 * @author saurabhj
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	private List<String> aliasNames;
	private List<Employment> employments;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Employment> getEmployments() {
		return employments;
	}
	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}
	public List<String> getAliasNames() {
		return aliasNames;
	}
	public void setAliasNames(List<String> aliasNames) {
		this.aliasNames = aliasNames;
	}
}
