package Kodprov;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Number {
    // an ID number is a Number that has some formatting rules and a Luhns verification number

    String idNumber = "";
    public Number(String idNumber){
        this.idNumber = idNumber;
    }

    public boolean validate() {

        if (!hasCorrectDigitFormatting()){
            System.out.println("fail: does not have correct formatting");
            return false;
            // if formatting is wrong, then there's no point to continue checking
            // because we don't know which digit refers to month and such
        }

        if (!hasValidLuhnsNumber()){
            System.out.println("fail: Luhns number is not valid");
            return false;
        }

        return true;
    }

    public boolean hasCorrectDigitFormatting(){
        final List<Pattern> rxs = new ArrayList<>();

        // possible formats
        rxs.add(Pattern.compile("[0-9]{10,12}")); // 9810013509
        // rxs.add(Pattern.compile("[0-9]{12}")); // 199810013509
        rxs.add(Pattern.compile("[0-9]{6,8}-[0-9]{4}")); // 981001-3509
        //rxs.add(Pattern.compile("[0-9]{10}-[0-9]{4}")); // 19981001-3509
        // assume it is not allowed to use a "+" with 12 digits


        for (Pattern rx : rxs) if (rx.matcher(idNumber).matches()) return true;
        return false;
    }

    public boolean hasValidLuhnsNumber(){

        // remove all non-digit symbols (plus or minus)
        String numberOnly = idNumber.replaceAll("[^0-9]", "");
        char lastDigit = numberOnly.charAt(numberOnly.length() - 1);

        //remove the first two digits of the birthyear and the last digit
        if (numberOnly.length() == 12){
            numberOnly = numberOnly.substring(2, 11);
        } else if (numberOnly.length() == 10){
            numberOnly = numberOnly.substring(0, 9);
        }

        // Lughns algorithm
        int tempsum;
        int numsum = 0;

        for (int i = 0; i < numberOnly.length(); i++) {
            int asChar = numberOnly.charAt(i);
            int asDigit = Character.getNumericValue(asChar);

            if (i%2==0){
                tempsum = asDigit * 2;
                if (tempsum > 9){
                    numsum += tempsum % 10;
                    tempsum /= 10;
                    numsum += tempsum;
                }else{
                    numsum += asDigit * 2;
                }
            } else {
                numsum += asDigit;
            }
        }
        int luhns = (10 - (numsum % 10)) % 10; // this is the calculated luhns number
        //System.out.println("NUMMM" + luhns);
        int lastDigitAsInt = Character.getNumericValue(lastDigit);
        return lastDigitAsInt == luhns;
    }


    public String getBirthMonth(){
        String numberOnly = idNumber.replaceAll("[^0-9]", "");
        String month = ""; // max 12
        if (numberOnly.length() == 12){
            month = numberOnly.substring(4, 6);
        } else if (numberOnly.length() == 10){
            month = numberOnly.substring(2, 4);
        }
        return month;
    }

    public String getBirthDay(){
        String numberOnly = idNumber.replaceAll("[^0-9]", "");
        String day = ""; // max 31
        if (numberOnly.length() == 12){
            day = numberOnly.substring(6, 8);
        } else if (numberOnly.length() == 10){
            day = numberOnly.substring(4, 6);
        }
        return day;
    }
}
