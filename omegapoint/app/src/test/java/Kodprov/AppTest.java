/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Kodprov;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AppTest {
    @Test
    public void validSocialSecurityNumbersPass() {

        ArrayList<String> validNumbers = new ArrayList<>();
        validNumbers.add("141206-2380");
        validNumbers.add("20080903-2386");
        validNumbers.add("198107249289");
        validNumbers.add("19021214-9819");
        validNumbers.add("190910199827");
        validNumbers.add("191006089807");
        validNumbers.add("192109099180");
        validNumbers.add("4607137454");
        validNumbers.add("194510168885");
        validNumbers.add("900118+9811");
        validNumbers.add("189102279800");
        validNumbers.add("189912299816");

        for(String num : validNumbers){
            SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber(num);
            assertTrue(socialSecurityNumber.validate());
        }

    }
    @Test public void invalidSocialSecurityNumbersDoNotPass() {
        ArrayList<String> invalidNumbers = new ArrayList<>();
        invalidNumbers.add("201701272394");
        invalidNumbers.add("190302299813");

        for(String num : invalidNumbers){
            SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber(num);
            assertFalse(socialSecurityNumber.validate());
        }
    }

    /*
    @Test
    void test(CapturedOutput output) {
        System.out.println("oka");
        assertTrue(output.getOut().contains("okasdasasd"));
        //System.err.println("error");
    } */

}
