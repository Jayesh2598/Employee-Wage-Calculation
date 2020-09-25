package assignment1;

import java.util.Random;

public class EWCP {
	
	public static final int WAGE_PER_HOUR = 20;
	public static final int PART_TIME= 1;
	public static final int FULL_DAY= 2;
	public static final int DAYS_PER_MONTH= 20;
	public static final int HOURS_PER_MONTH= 100;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Employee Wage Computation Program!");
		int empHours=0;
		Random ran = new Random();
		int empType = ran.nextInt(3);
		
		//Checking if employee is present and their type		
		switch (empType) {
			case FULL_DAY:
				System.out.println("Full time employee.");
				empHours=8;
				break;
				
			case PART_TIME:
				System.out.println("Part time employee.");
				empHours=4;
				break;
				
			default:
				System.out.println("Employee absent.");
				empHours=0;
				break;
		}
		System.out.println("Wages\t Days\t Hours Worked");
		
		//Calculating monthly wage
		int monthlyWage= calculateWage(empHours);
		
		
		System.out.println("The monthly wage before the conditions are reached is : "+ monthlyWage);
	}
	
	public static int calculateWage(int empHours) {
		int hoursWorked=0;
		int monthlyWage=0;
		int days=0;
		int empWage= WAGE_PER_HOUR * empHours;
		
		while((hoursWorked+empHours)<=100 && days<20){						//Calculating till the nearest multiple of empHours less than 100
			monthlyWage += empWage;
			hoursWorked += empHours;
			days++;
			System.out.println(monthlyWage+"\t"+days+"\t"+hoursWorked);
		};
		if(hoursWorked!=100 && days<20) {									//Calculating from nearest multiple of empHours to 100
			for(int i=hoursWorked;i<100;i++) 
				monthlyWage += WAGE_PER_HOUR;
			System.out.println(monthlyWage+"\t"+(++days)+"\t"+HOURS_PER_MONTH);
		}
		return monthlyWage;
	}

}