package codewithmosh;

public class Employee {
	private int basicSalary;
	private int hourlyRate;
	
	public int calculateWage(int extraHours) {
		return basicSalary + (extraHours * hourlyRate);
	}
	
	public void setbasicSalary(int basicSalary) {
		if (basicSalary <= 0)
			throw new IllegalArgumentException("Salary cannot be 0 or less.");
		else
			this.basicSalary = basicSalary;
	}
	
	public int getBasicSalary() {
		return basicSalary;
	}
	
	public void setHourlyRate(int hourlyRate) {
		if (hourlyRate <= 0)
			throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
		else
			this.hourlyRate = hourlyRate;
	}
	
	public int getHourlyRate() {
		return hourlyRate;
	}
	
	
	
	

}
