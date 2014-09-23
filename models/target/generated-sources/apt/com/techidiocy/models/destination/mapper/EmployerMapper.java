/**Auto generated code,don't modify it.
* Author             ---- > Auto Generated.
* Date  and Time     ---- > Mon Sep 22 17:30:22 IST 2014
* Source             -----> com.techidiocy.models.source.Employer
* Destination        -----> com.techidiocy.models.destination.EmployerDTO
***/



package com.techidiocy.models.destination.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.techidiocy.models.source.Employer;
import com.techidiocy.models.destination.EmployerDTO;


public class EmployerMapper {


public EmployerDTO mapSourceToDTO(Employer source) { 
   EmployerDTO employerdto = new EmployerDTO();
   employerdto.setEmployerName(source.getEmployerName()); 
   AddressMapper addressMapper = new AddressMapper();
   employerdto.setEmployerAddress(addressMapper.mapSourceToDTO(source.getEmployerAddress())); 
   employerdto.setNoOfEmployees(source.getNoOfEmployees()); 
   return employerdto;
}
}
