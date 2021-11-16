package codewithmosh;

public class WageCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee employee = new Employee();
		employee.setbasicSalary(50000);
		employee.getBasicSalary();
		employee.setHourlyRate(20);
		employee.getHourlyRate();
		int wage = employee.calculateWage(10);
		System.out.println(wage);
	}
		
		
		  

	

}
