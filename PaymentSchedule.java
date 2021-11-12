package codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
	final static byte MONTHS_IN_A_YEAR = 12;
	final static byte PERCENTAGE = 100;

     public static void main(String[] args) {
		// TODO Auto-generated method stub
    	 
    	
  	
		float principal = (float)ReadNumber("Principal: ", 1000, 1000000);
		float annualInterest = (float)ReadNumber("Annual Interest Rate: ", 1,30);
		byte years = (byte)ReadNumber("Period(Years): ", 1,30);
		
		float monthlyInterest = annualInterest/PERCENTAGE/MONTHS_IN_A_YEAR;
   	    short numberOfPayments = (short)(years * MONTHS_IN_A_YEAR);
		
		printMortgage(principal, annualInterest, years);
		printPaymentSchedule(MONTHS_IN_A_YEAR, principal, annualInterest, years);
		
	}

	private static void printMortgage(float principal, float annualInterest, byte years) {
		double mortgage = CalculateMortgage(principal, annualInterest, years);
		
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println();
		System.out.println("MORTGAGE");
		System.out.println("----------");
		System.out.println("Monthly Payments: " + mortgageFormatted);
	}

	private static void printPaymentSchedule(final byte MONTHS_IN_A_YEAR, float principal, float annualInterest,
			byte years) {
		System.out.println();
		System.out.println("PAYMENT SCHEDULE");
		System.out.println("-----------------");
		for (short months = 1; months <= years * MONTHS_IN_A_YEAR; months++){
		double loanBalance = calculateBalance(principal, annualInterest,years,months);
		String loanBalanceFormatted = NumberFormat.getCurrencyInstance().format(loanBalance);
		System.out.println(loanBalanceFormatted);
		}
	}
     
      public static double ReadNumber(String prompt, int min, int max) {
    	 Scanner input = new Scanner(System.in);
    	 double value = 0;
    	 
    	while(true) {
    	System.out.print(prompt);
 		value = input.nextDouble();
 		if (value >= min && value <= max) 
 		break;
 		else
 			System.out.println("Enter a value between " + min + " and " + max);
    	 }
 		
 	return value;
 	
    	 
  }
     public static double calculateBalance(float principal,
                                           float annualInterest, 
                                           byte years,
                                           short numberOfPaymentsMade) {
    	 
    	
    	
   	    float monthlyInterest = annualInterest/PERCENTAGE/MONTHS_IN_A_YEAR;
     	short numberOfPayments = (short)(years * MONTHS_IN_A_YEAR);
     	
    	 double loanBalance = principal *
    			              (Math.pow((1 + monthlyInterest), numberOfPayments)- Math.pow((1 + monthlyInterest), numberOfPaymentsMade))/
    			              (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    	 return loanBalance;
     }
     
     
      public static double CalculateMortgage(float principal,
    		                            float annualInterest, 
    		                            byte years){
	 
  		float monthlyInterest = annualInterest/PERCENTAGE/MONTHS_IN_A_YEAR;
    	short numberOfPayments = (short)(years * MONTHS_IN_A_YEAR);
    	
    	double mortgage = principal *
		          monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)/
		          Math.pow((1 + monthlyInterest), numberOfPayments) - 1;
    	
    	return mortgage;
    }	
    
}
