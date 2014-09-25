/**Auto generated code,don't modify it.
* Author             ---- > Auto Generated.
* Date  and Time     ---- > Thu Sep 25 12:15:37 IST 2014
* Source             -----> com.techidiocy.models.source.Employment
* Destination        -----> com.techidiocy.models.destination.EmploymentDTO
***/



package com.techidiocy.models.destination.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.techidiocy.models.source.Employment;
import com.techidiocy.models.destination.EmploymentDTO;


public class EmploymentMapper {


public EmploymentDTO mapSourceToDTO(Employment source) { 
   EmploymentDTO employmentdto = new EmploymentDTO();
   EmployerMapper employerMapper = new EmployerMapper();
   employmentdto.setEmployer(employerMapper.mapSourceToDTO(source.getEmployer())); 
   employmentdto.setStartDate(source.getStartDate()); 
   employmentdto.setEndDate(source.getEndDate()); 
   employmentdto.setSalary(source.getSalary()); 
   employmentdto.setCurrent(source.isCurrent()); 
   return employmentdto;
   }
}
