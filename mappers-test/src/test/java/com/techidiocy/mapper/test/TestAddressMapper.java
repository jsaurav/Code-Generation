package com.techidiocy.mapper.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techidiocy.models.destination.AddressDTO;
import com.techidiocy.models.destination.mapper.AddressMapper;
import com.techidiocy.models.mock.factory.MockObjectCreator;
import com.techidiocy.models.source.Address;

public class TestAddressMapper {
	
	private static AddressMapper addressMapper = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		addressMapper = new AddressMapper();
	}

	@Test
	public void test() {
		Address address = MockObjectCreator.mockAddressInstance();
		AddressDTO addressDTO = addressMapper.mapSourceToDTO(address);
		
		Assert.assertEquals("Address Line 1 doesn't match", addressDTO.getAddressLine1(), address.getAddressLine1());
		Assert.assertEquals("Address Line 2 doesn't match", addressDTO.getAddressLine2(), address.getAddressLine2());
		Assert.assertEquals("City doesn't match", addressDTO.getCity(), address.getCity());
		Assert.assertEquals("State doesn't match", addressDTO.getState(), address.getState());
		Assert.assertEquals("Zipcode doesn't match", addressDTO.getZipcode(), address.getZipcode());
		
	}

}
