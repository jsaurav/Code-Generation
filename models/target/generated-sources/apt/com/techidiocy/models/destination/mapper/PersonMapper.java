/**Auto generated code,don't modify it.
* Author             ---- > Auto Generated.
* Date  and Time     ---- > Tue Sep 23 10:46:06 IST 2014
* Source             -----> com.techidiocy.models.source.Person
* Destination        -----> com.techidiocy.models.destination.PersonDTO
***/



package com.techidiocy.models.destination.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.techidiocy.models.source.Person;
import com.techidiocy.models.destination.PersonDTO;
import com.techidiocy.models.source.Employment;
import com.techidiocy.models.destination.EmploymentDTO;


public class PersonMapper {


public PersonDTO mapSourceToDTO(Person source) { 
   PersonDTO persondto = new PersonDTO();
   persondto.setFirstName(source.getFirstName()); 
   persondto.setLastName(source.getLastName()); 
   persondto.setAge(source.getAge()); 
   AddressMapper addressMapper = new AddressMapper();
   persondto.setAddress(addressMapper.mapSourceToDTO(source.getAddress())); 
   persondto.setAliasNames(source.getAliasNames()); 
   EmploymentMapper employmentMapper = new EmploymentMapper();
   List<EmploymentDTO> employmentdtoList = new ArrayList<EmploymentDTO>();
   for(Employment employment: source.getEmployments()) { 
      employmentdtoList.add(employmentMapper.mapSourceToDTO(employment));
   }
   persondto.setEmployments(employmentdtoList); 
   return persondto;
}
}
