package Kodprov;

public class OrganisationNumber extends IDNumber{

    public OrganisationNumber(String idNumber) {
        super(idNumber);
    }
    // a coordination number is a social security number with altered month

    // an organisation number is an IDNumber for companies
    // has additional rules:
    // "month" has to be at least 20
    // "year" can be 16 or nothing


    public boolean validate() {

        if (!super.validate()) return false;
        if (Integer.valueOf(getBirthMonth()) < 20) return false;
        if (idNumber.length() == 12 && getBirthYear() != "16") return false;

        return true;
    }

}
