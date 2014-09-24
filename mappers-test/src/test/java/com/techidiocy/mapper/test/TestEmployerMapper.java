/**
 * 
 */
package com.techidiocy.mapper.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techidiocy.models.destination.EmployerDTO;
import com.techidiocy.models.destination.mapper.EmployerMapper;
import com.techidiocy.models.mock.factory.MockObjectCreator;
import com.techidiocy.models.source.Employer;

/**
 * @author saurabhj
 *
 */
public class TestEmployerMapper {

	private static EmployerMapper employerMapper = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		employerMapper = new EmployerMapper();
	}

	@Test
	public void test() {
		Employer employer = MockObjectCreator.mockEmployerInstance();
		EmployerDTO employerDTO = employerMapper.mapSourceToDTO(employer);
		
		Assert.assertEquals("Address Line 1 doesn't match", employerDTO.getEmployerAddress().getAddressLine1(), employer.getEmployerAddress().getAddressLine1());
		Assert.assertEquals("Address Line 2 doesn't match", employerDTO.getEmployerAddress().getAddressLine2(), employer.getEmployerAddress().getAddressLine2());
		Assert.assertEquals("City doesn't match", employerDTO.getEmployerAddress().getCity(), employer.getEmployerAddress().getCity());
		Assert.assertEquals("State doesn't match", employerDTO.getEmployerAddress().getState(), employer.getEmployerAddress().getState());
		Assert.assertEquals("Zipcode doesn't match", employerDTO.getEmployerAddress().getZipcode(), employer.getEmployerAddress().getZipcode());
		Assert.assertEquals("Employer name doesn't match", employerDTO.getEmployerName(), employer.getEmployerName());
		Assert.assertEquals("No of Employees doesn't match", employerDTO.getNoOfEmployees(), employer.getNoOfEmployees());
	}

}
