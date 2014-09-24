/**
 * 
 */
package com.techidiocy.mapper.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techidiocy.models.destination.PersonDTO;
import com.techidiocy.models.destination.mapper.PersonMapper;
import com.techidiocy.models.mock.factory.MockObjectCreator;
import com.techidiocy.models.source.Person;

/**
 * @author saurabhj
 *
 */
public class TestPersonMapper {
	
	private static PersonMapper personMapper = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		personMapper = new PersonMapper();
	}

	@Test
	public void test() {
		Person person = MockObjectCreator.mockPersonInstance();
		PersonDTO personDTO = personMapper.mapSourceToDTO(person);
		
		Assert.assertEquals("Address Line 1 doesn't match", personDTO.getAddress().getAddressLine1(), person.getAddress().getAddressLine1());
		Assert.assertEquals("Address Line 2 doesn't match", personDTO.getAddress().getAddressLine2(), person.getAddress().getAddressLine2());
		Assert.assertEquals("City doesn't match", personDTO.getAddress().getCity(), person.getAddress().getCity());
		Assert.assertEquals("State doesn't match", personDTO.getAddress().getState(), person.getAddress().getState());
		Assert.assertEquals("Zipcode doesn't match", personDTO.getAddress().getZipcode(), person.getAddress().getZipcode());
		
		Assert.assertEquals("First Name doesn't match", personDTO.getFirstName(), person.getFirstName());
		Assert.assertEquals("Last Name doesn't match", personDTO.getLastName(), person.getLastName());
		Assert.assertEquals("Age doesn't match", personDTO.getAge(), person.getAge());	
		
		
		Assert.assertEquals("No of alias names doeesn't match", personDTO.getAliasNames().size(), person.getAliasNames().size());
		
		for (int i = 0 ; i<personDTO.getAliasNames().size();i++) {
			Assert.assertEquals("Alias Name "+i+" doesn't match", personDTO.getAliasNames().get(i), person.getAliasNames().get(i));
		}
		
		Assert.assertEquals("No of Employments doesn't match", personDTO.getEmployments().size(), person.getEmployments().size());
		
		for (int i = 0 ; i<personDTO.getEmployments().size();i++) {
			Assert.assertEquals("Address Line 1 of record " +i+" doesn't match", personDTO.getEmployments().get(i).getEmployer().getEmployerAddress().getAddressLine1(), person.getEmployments().get(i).getEmployer().getEmployerAddress().getAddressLine1());
			Assert.assertEquals("Address Line 2 of record " +i+" doesn't match", personDTO.getEmployments().get(i).getEmployer().getEmployerAddress().getAddressLine2(), person.getEmployments().get(i).getEmployer().getEmployerAddress().getAddressLine2());
			Assert.assertEquals("City of record " +i+" doesn't match", personDTO.getEmployments().get(i).getEmployer().getEmployerAddress().getCity(), person.getEmployments().get(i).getEmployer().getEmployerAddress().getCity());
			Assert.assertEquals("State of record " +i+" doesn't match", personDTO.getEmployments().get(i).getEmployer().getEmployerAddress().getState(), person.getEmployments().get(i).getEmployer().getEmployerAddress().getState());
			Assert.assertEquals("Zipcode of record " +i+" doesn't match", personDTO.getEmployments().get(i).getEmployer().getEmployerAddress().getZipcode(), person.getEmployments().get(i).getEmployer().getEmployerAddress().getZipcode());
			Assert.assertEquals("Salary of record " +i+" doesn't match", personDTO.getEmployments().get(i).getSalary(), person.getEmployments().get(i).getSalary());
			Assert.assertEquals("Starte Date of record " +i+" doesn't match", personDTO.getEmployments().get(i).getStartDate(), person.getEmployments().get(i).getStartDate());
			Assert.assertEquals("End Date of record " +i+" doesn't match", personDTO.getEmployments().get(i).getEndDate(), person.getEmployments().get(i).getEndDate());		
		}
	}

}
