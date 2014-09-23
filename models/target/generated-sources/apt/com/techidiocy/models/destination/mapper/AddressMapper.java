/**Auto generated code,don't modify it.
* Author             ---- > Auto Generated.
* Date  and Time     ---- > Tue Sep 23 10:46:06 IST 2014
* Source             -----> com.techidiocy.models.source.Address
* Destination        -----> com.techidiocy.models.destination.AddressDTO
***/



package com.techidiocy.models.destination.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.techidiocy.models.source.Address;
import com.techidiocy.models.destination.AddressDTO;


public class AddressMapper {


public AddressDTO mapSourceToDTO(Address source) { 
   AddressDTO addressdto = new AddressDTO();
   addressdto.setAddressLine1(source.getAddressLine1()); 
   addressdto.setAddressLine2(source.getAddressLine2()); 
   addressdto.setCity(source.getCity()); 
   addressdto.setState(source.getState()); 
   addressdto.setZipcode(source.getZipcode()); 
   return addressdto;
}
}
