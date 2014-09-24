/**
 * 
 */
package com.techidiocy.mapper.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techidiocy.models.destination.EmploymentDTO;
import com.techidiocy.models.destination.mapper.EmploymentMapper;
import com.techidiocy.models.mock.factory.MockObjectCreator;
import com.techidiocy.models.source.Employment;

/**
 * @author saurabhj
 *
 */
public class TestEmploymentMapper {

	private static EmploymentMapper employmentMapper = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		employmentMapper = new EmploymentMapper();
	}

	@Test
	public void test() {
		Employment employment = MockObjectCreator.mockEmploymentInstance();
		EmploymentDTO employmentDTO = employmentMapper.mapSourceToDTO(employment);
		
		Assert.assertEquals("Address Line 1 doesn't match", employmentDTO.getEmployer().getEmployerAddress().getAddressLine1(), employment.getEmployer().getEmployerAddress().getAddressLine1());
		Assert.assertEquals("Address Line 2 doesn't match", employmentDTO.getEmployer().getEmployerAddress().getAddressLine2(), employment.getEmployer().getEmployerAddress().getAddressLine2());
		Assert.assertEquals("City doesn't match", employmentDTO.getEmployer().getEmployerAddress().getCity(), employment.getEmployer().getEmployerAddress().getCity());
		Assert.assertEquals("State doesn't match", employmentDTO.getEmployer().getEmployerAddress().getState(), employment.getEmployer().getEmployerAddress().getState());
		Assert.assertEquals("Zipcode doesn't match", employmentDTO.getEmployer().getEmployerAddress().getZipcode(), employment.getEmployer().getEmployerAddress().getZipcode());
		Assert.assertEquals("Employer name doesn't match", employmentDTO.getSalary(), employment.getSalary());
		Assert.assertEquals("Start Date doesn't match", employmentDTO.getStartDate(), employment.getStartDate());
		Assert.assertEquals("End Date doesn't match", employmentDTO.getEndDate(), employment.getEndDate());		
	}
}
