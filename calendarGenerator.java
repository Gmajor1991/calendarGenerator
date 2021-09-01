/*This program takes in a year in integer form, and the day on which that year began (also in integer form),
 * and returns a formatted calendar featuring each month of that year.
 * This is a simple exercise in formatting and exception handling
*/

package CalendarGeneratorPackage;

import java.util.Scanner;

public class calendarGenerator {

public static void main(String[] args) {
		
		//Creates a Scanner instance, to take in input from the user
		Scanner input = new Scanner(System.in);
		
		//Prompts the user to enter a year in integer form
		System.out.print("Enter a year in numeric form: ");
		int year = input.nextInt();
		
		System.out.print("Enter the first weekday of that year,"
				+ " in numeric form (Sunday being 1, "
				+ "Monday being 2, and so on): ");

		//Creates a Scanner instance to accept input from the user, in the form of an integer.
		int dayNum = input.nextInt();
		
		/*
		Prompts the user to re-enter the weekday number, if their input was invalid.
		while(dayNum<= 0 || dayNum > 7) {
			System.out.println("Error: invalid input.\nPlease enter a whole number between 1 and 7 (inclusive).");
			dayNum = input.nextInt();
		}
		*/
		
		//This do-while loop prompts the user to re-enter the weekday number, if their input was invalid.
		do {
			System.out.print("Enter the first weekday of that year,"
					+ " in numeric form (Sunday being 1, "
					+ "Monday being 2, and so on): ");
			
		} while(dayNum<= 0 || dayNum > 7);
		
		
		//Defines a leap year.
		boolean leapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
		
		//Converts user's choice of day from numeric to alphabetical form.
			switch (dayNum)  {
				case 1:
					System.out.println("Sunday ");
					break;
				case 2:
					System.out.println("Monday ");
					break;
				case 3:
					System.out.println("Tuesday ");
					break;
				case 4:
					System.out.println("Wednesday ");
					break;
				case 5:
					System.out.println("Thursday ");
					break;
				case 6:
					System.out.println("Friday ");
					break;
				case 7:
					System.out.println("Saturday ");
					break;
			}
			
		//Establishes the number of days in a month.
		int numDaysMonth = 0;
		for (int month = 1; month <= 12; month++) 
		{
			switch (month) 
			{
				case 1: 
					System.out.println("	   January " + year);
					numDaysMonth = 31;
					break;
				case 2:
					System.out.println("	   February " + year);
						if (leapYear) {	
							numDaysMonth = 28;
						}
						else {
							numDaysMonth = 29;
						}
					break;
				case 3:
					System.out.println("	   March " + year);
					numDaysMonth = 31;
					break;
				case 4:
					System.out.println("	   April " + year);
					numDaysMonth = 30;
					break;
				case 5:
					System.out.println("	   May " + year);
					numDaysMonth = 31;
					break;
				case 6:
					System.out.println("	   June " + year);
					numDaysMonth = 30;
					break;
				case 7:
					System.out.println("	   July " + year);
					numDaysMonth = 31;
					break;
				case 8:
					System.out.println("	   August " + year);
					numDaysMonth = 31;
					break;
				case 9:
					System.out.println("	   September " + year);
					numDaysMonth = 30;
					break;
				case 10:
					System.out.println("	   October " + year);
					numDaysMonth = 31;
					break;
				case 11:
					System.out.println("	   November " + year);
					numDaysMonth = 30;
					break;
				case 12:
					System.out.println("	   December " + year);
					numDaysMonth = 31;
					break;		
			}
			System.out.println(String.format("%36s", "").replace(" ", "_"));
			//System.out.printf("%-6s%-6s%-6s%-6s%-6s%-6s%-6s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
			System.out.println("  Sun  Mon  Tue  Wed  Thu  Fri  Sat");
			
			 for (int i = 0; i < dayNum; i++) {
	                System.out.print("     ");
	            }
	            for (int i = 1; i <= numDaysMonth; i++)
	            {
	                if (i < 10) {
	                    System.out.print("    " + i);
	                } else {
	                    System.out.print("   " + i);
	                }
	                if ((i + dayNum) % 7 == 0) {
	                    System.out.println();
	                }
	            }
	            //Prints a blank line before the next month.
	            System.out.println("\n");

	            /*
	             *Line 148 ensures that for every month after January, the first day falls on the weekday
	             *following the last day of the previous month, instead of having every
	             *month start on the weekday entered by the user.
	             */
	            dayNum = (dayNum + numDaysMonth) % 7;
		}
	}

}
