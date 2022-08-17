# Kodprov

## About

Validate 3 different types of numbers: 
- Social Security Number
- Coordination Number
- Organisation Number

## Implementation

Number: contains the checks that are common between the 3 different number types. 
These checks are: common formatting rules, and verify Luhns number.

Social Security Number: is a Number with additional rules. It can be formatted with a "+"
and needs checking for whether the date exists.

Coordination Number: is a Social Security Number with an additional rule for the "month" number.

Organisation Number: is a Number with restrictions that "month" has to be at least 20
and "year" must be either 16 or nothing.

## Run

App has the main function. When main is run, you can validate numbers via the terminal.

An example conversation goes like this:

Choose number to validate: (1) Social Security Number, (2) Coordination Number, (3) Organisation Number  
**1** (assumes a number 1-3)  
Enter Social Security Number  
**141206-2380**  
validation = true  
Validate another number? Y/N (assumes uppercase letter Y or N)  
**N**  

## Run with Gradle

Run main app

```
./gradlew run
```
Run main app without the "loading bar"
```
./gradlew run --console=plain
```

Run all tests
```
./gradlew test
```

Run specific test

```
 ./gradlew test --tests AppTest.validSocialSecurityNumbersPass
```
