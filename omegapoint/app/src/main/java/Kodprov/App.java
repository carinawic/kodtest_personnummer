package Kodprov;

//import main.java.Kodprov.Personnummer;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean execute;

        do{
            System.out.println("Choose number to validate: (1) Social Security Number, (2) Coordination Number, (3) Organisation Number");
            int in1 = input.nextInt();

            if(in1 == 1){
                System.out.println("Enter Social Security Number");
                String in2 = input.next();
                SocialSecurityNumber socialSecurityNumber = new SocialSecurityNumber(in2);
                System.out.println("validation = " + socialSecurityNumber.validate());
            }else if(in1 == 2){
                System.out.println("Enter Coordination Number");
                String in2 = input.next();
                CoordinationNumber coordinationNumber = new CoordinationNumber(in2);
                System.out.println("validation = " + coordinationNumber.validate());
            }
            else if(in1 == 3){
                System.out.println("Enter Organization Number");
                String in2 = input.next();
                OrganisationNumber organisationNumber = new OrganisationNumber(in2);
                System.out.println("validation = " + organisationNumber.validate());
            }
            System.out.println("Validate another number? Y/N");
            input.nextLine();
            String in3 = input.nextLine();
            if(in3.equals("Y")){
                execute = true;
            }else{
                execute = false;
            }
        }while(execute);

        input.close();

    }
}
