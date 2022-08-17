package Kodprov;

public class OrganisationNumber extends IDNumber{

    public OrganisationNumber(String idNumber) {
        super(idNumber);
    }
    // an organisation number is an IDNumber for companies
    // has additional rules:
    // "month" has to be at least 20
    // "year" can be 16 or nothing

    public boolean validate() {

        String numberOnly = idNumber.replaceAll("[^0-9]", "");

        if (!super.validate()) return false;
        if (Integer.valueOf(getBirthMonth()) < 20) {
            System.out.println("fail: middle number is less than 20");
            return false;
        }

        if (numberOnly.length() == 12 && !numberOnly.substring(0, 2).equals("16")) {
            System.out.println("fail: year does not start with 16");
            return false;
        }

        return true;
    }

}
