package Kodprov;

public class CoordinationNumber extends SocialSecurityNumber{
    // a coordination number is a special type of social security number
    // with altered month
    public CoordinationNumber(String idNumber) {
        super(idNumber);
    }

    public String getBirthDay(){
        int alteredBirthDay = Integer.valueOf(super.getBirthDay());
        int realBirthDay = alteredBirthDay - 60;
        return String.valueOf(realBirthDay);
    }
}
