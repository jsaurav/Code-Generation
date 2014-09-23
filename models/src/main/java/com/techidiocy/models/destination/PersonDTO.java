/**
 * 
 */
package com.techidiocy.models.destination;

import java.util.List;

import com.techidiocy.annotation.FieldMeta;
import com.techidiocy.annotation.Relation;

/**
 * @author saurabhj
 *
 */
@Relation(associatedSourceClass=com.techidiocy.models.source.Person.class)
public class PersonDTO extends BaseDTO {

	private String firstName;
	private String lastName;
	private int age;
	private AddressDTO address;
	private List<String> aliasNames;
	
	@FieldMeta(associatedSourceClass=com.techidiocy.models.source.Employment.class)
	private List<EmploymentDTO> employments;
	
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public List<EmploymentDTO> getEmployments() {
		return employments;
	}
	public void setEmployments(List<EmploymentDTO> employments) {
		this.employments = employments;
	}
	public List<String> getAliasNames() {
		return aliasNames;
	}
	public void setAliasNames(List<String> aliasNames) {
		this.aliasNames = aliasNames;
	}		
}
