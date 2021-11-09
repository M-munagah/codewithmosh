package codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		final byte MONTHS_IN_A_YEAR = 12;
		final byte PERCENTAGE = 100;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Principal: ");
		float principal = input.nextFloat();
		
		System.out.print("Annual Interest: ");
		float annualInterest = input.nextFloat();
		float monthlyInterest = annualInterest/PERCENTAGE/MONTHS_IN_A_YEAR;
		
		System.out.println("Period(Years): ");
		byte years = input.nextByte();
		int numberOfPayments = years * MONTHS_IN_A_YEAR;
		
		double mortgage = principal *
				          monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)/
				          Math.pow((1 + monthlyInterest), numberOfPayments) - 1;
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);
				          
	}

}
