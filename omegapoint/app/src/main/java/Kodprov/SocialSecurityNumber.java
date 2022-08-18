package Kodprov;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class SocialSecurityNumber extends Number {
    // a social security number is an IDNumber with more specifications
    public SocialSecurityNumber(String idNumber) {
        super(idNumber);
    }

    public boolean validate() {
        if (!super.validate()) return false;
        // we additionally log if the date does not exist
        if (!dateExists()){
            System.out.println("fail: date does not exist");
            return false;
        }
        return true;
    }

    public boolean hasCorrectDigitFormatting(){
        // possible formats
        Pattern pattern = Pattern.compile("[0-9]{6}\\+[0-9]{4}"); // 981001+3509
        // return true if we match either the overall ID formats or the human format
        return super.hasCorrectDigitFormatting() || pattern.matcher(idNumber).matches();
    }

    public boolean dateExists(){
        // for example, the 31st february does not exist
        return validateDate(getBirthMonth() + getBirthDay());
    }

    public boolean validateDate(String dateToValidate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("MMdd");
            format.setLenient(false);
            format.parse(dateToValidate);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
