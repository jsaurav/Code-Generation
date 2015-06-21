Code-Generation
===============

Code Generation at compile time using annotation processor.

This project contains 3 modules.

1. Module Contains source and destination models (**models**).
2. Module contains actual annotation processor logic (**annotation-processors**).
3. Test module that verifies the working of generated mappers (**mappers-test**).

### models :
This module contains all the source and destination models for which we are going to generate the mappers.

### annotation-processors :
This module contains the actual processor which generates the mappers at compile time for our models defined in the models module.

### mappers-test :
This module will test the working of generated mappers using JUnit test , there is an unit test present corresponding to each mapper.

## How to run :
At the parent project i.e **Code-Generation** just issue the below mentioned command.

`mvn clean install`

Once build is successful , you can see the generated mappers in **models** module at this location.

`Code-Generation/models/target/generated-sources/apt/com/techidiocy/models/destination/mapper`
