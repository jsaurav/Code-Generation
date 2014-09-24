/**
 * 
 */
package com.techidiocy.models.mock.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techidiocy.models.source.Address;
import com.techidiocy.models.source.Employer;
import com.techidiocy.models.source.Employment;
import com.techidiocy.models.source.Person;

/**
 * @author saurabhj
 *
 */
public class MockObjectCreator {

	private static final String ADDRESS_LINE_1 = "10 Florence ST";
	private static final String ADDRESS_LINE_2 = "207";
	private static final String CITY           = "BOSTON";
	private static final String STATE          = "MA";
	private static final int    ZIPCODE           = 2148;
	
	private static final String EMPLOYER_NAME  = "Techidiocy";
	private static final int    NUM_OF_EMPLOYEES = 1000;
	
	private static final long   SALARY  = 100000;
	private static final Date   START_DATE  = new Date();
	private static final Date   END_DATE  = new Date();
	
	private static final String FIRST_NAME  = "John";
	private static final String LAST_NAME   = "Doe";
	private static final int    AGE         = 26;
	private static final int    NO_OF_EMPLOYMENTS = 4;
	
	public static Address mockAddressInstance() {
		Address address = new Address();
		address.setAddressLine1(ADDRESS_LINE_1);
		address.setAddressLine2(ADDRESS_LINE_2);
		address.setCity(CITY);
		address.setState(STATE);
		address.setZipcode(ZIPCODE);
		return address;
	}
	
	public static Employer mockEmployerInstance() {
		Employer employer = new Employer();
		employer.setEmployerAddress(mockAddressInstance());
		employer.setEmployerName(EMPLOYER_NAME);
		employer.setNoOfEmployees(NUM_OF_EMPLOYEES);
		return employer;
	}
	
	public static Employment mockEmploymentInstance() {
		Employment employment = new Employment();
		employment.setCurrent(true);
		employment.setEmployer(mockEmployerInstance());
		employment.setEndDate(END_DATE);
		employment.setStartDate(START_DATE);
		employment.setSalary(SALARY);
		return employment;
	}
	
	public static Person mockPersonInstance() {
		Person person = new Person();
		person.setAddress(mockAddressInstance());
		person.setAge(AGE);
		person.setFirstName(FIRST_NAME);
		person.setLastName(LAST_NAME);
		person.setAliasNames(mockAliasNames());
		person.setEmployments(mockEmployments());
		return person;
	}

	private static List<Employment> mockEmployments() {
		List<Employment> employments = new ArrayList<Employment>();
		for(int i=0;i<NO_OF_EMPLOYMENTS;i++) {
			employments.add(mockEmploymentInstance());
		}
		return employments;
	}

	private static List<String> mockAliasNames() {
		List<String> aliasNames = new ArrayList<String>();
		aliasNames.add("Johny");
		aliasNames.add("Joe");
		return aliasNames;
	}
}
