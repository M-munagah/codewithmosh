package codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		final byte MONTHS_IN_A_YEAR = 12;
		final byte PERCENTAGE = 100;
		
		float principal = 0;
		float monthlyInterest = 0;
		int numberOfPayments = 0;
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
		System.out.print("Principal(1K-1M): ");
		 principal = input.nextFloat();
		if (principal >= 1000 && principal <= 1000000) 
			break;
		else
			System.out.println("Enter a value between 1,000 and 1,000,000");
		}
		
		
		while(true) {
		System.out.print("Annual Interest: ");
		float annualInterest = input.nextFloat();
		if (annualInterest >= 1 && annualInterest<= 30) {
		monthlyInterest = annualInterest/PERCENTAGE/MONTHS_IN_A_YEAR;
		break;
		}
		else
			System.out.println("Enter a value between 1 and 30");
		}
		
		
		while(true) {
		System.out.print("Period(Years): ");
		byte years = input.nextByte();
		if (years >= 1 && years <= 30) {
		numberOfPayments = years * MONTHS_IN_A_YEAR;
		break;
		}
		else
			System.out.println("Enter a value between 1 and 30");
		}
		double mortgage = principal *
				          monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)/
				          Math.pow((1 + monthlyInterest), numberOfPayments) - 1;
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);
				          
	}

}
