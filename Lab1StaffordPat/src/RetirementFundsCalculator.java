import java.util.Scanner;

public class RetirementFundsCalculator {
    
    
        
    public static void EachMonth() {
    	Scanner year= new Scanner (System.in);
        System.out.println("How many years longer will you work?");
       
        int years=year.nextInt();
        System.out.println("What is the return rate of your savings account?");
        double returnrate=year.nextDouble();
        System.out.println("How many years do you want to be retired?");
        int yearsretired=year.nextInt();
        System.out.println("What is your annual return rate after retirement?");
        double returnrateafterretired=year.nextDouble();
        System.out.println("What is your required income when you retire?");
        double requiredincome=year.nextDouble();
        System.out.println("What is your expected SSI payment?");
        double expectedssi=year.nextDouble();
        
        //First we need to get The total amount need saved, based on ssi,required income, retired return rate
        // and years retired. THis is the PV in the excel sheet, and based on the function:
        //c(1-(1+i)^n)/i c is value needed per time period, i is the interest rate, and n is the number of periods this value will compound
        double moneyneeded=(requiredincome-expectedssi)*((1-Math.pow(1+returnrateafterretired/12, yearsretired*-12))/(returnrateafterretired/12));
        
        
        System.out.println("You need  $" + moneyneeded + " to retire");
        
        // Now we must use the money needed to solve amount required to save per month, based on years working and the interest rate during those years
        double permonth=moneyneeded*((returnrate/12)/(1-Math.pow(1+returnrate/12,years*12)));
        
        // Note that the permonth value is the amount to be taken away each month, so it will be negative
        // so we will just multiply it by -1 so that the out statement makes sense
;        System.out.println("You need to save  $" + -permonth + " per month to retire");
    }
    public static void main(String args[]){
    	EachMonth();
    }
}