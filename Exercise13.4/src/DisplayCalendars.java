/**
 * Author: Melissa Bakke
 * Date: 01/19/2017
 * Class: CIS171-101
 * Assignment: Exercise 13.4
 */
import java.util.*;
import java.util.Scanner;

public class DisplayCalendars {
    // Main method
    public static void main(String[] args) {  
        int year = getUserYear();
        int month = getUserMonth();
        
        // New instance of Gregorian Calendar
        Calendar gregCal = new GregorianCalendar(year, month-1, 1);
        
        // Print calendar for the month of the year
        printMonth(gregCal);
    }// end Main method
    
    // Print the calendar for a month in a year
    public static void printMonth(Calendar cal) {
        // Print the headings of the calendar
        printMonthTitle(cal);
        
        // Print the body of the calendar
        printMonthBody(cal);
    }// end printMonth
    
    // Print the month title
    public static void printMonthTitle(Calendar cal) {
        System.out.println("         " + cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + cal.get(Calendar.YEAR));
        System.out.println("---------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    } // end printMonthTitle
    
    // Print month body
    public static void printMonthBody(Calendar cal) {
        // Get start day of the week for the first date in the month
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        
        // Get number of days in the month
        int numberOfDaysInMonth = cal.getMaximum(Calendar.DAY_OF_MONTH);
        
        // Pad space before first day
        for (int i = 1; i < startDay; i++) {
            System.out.print("    ");
        }
        
        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);            
            if ((i + (startDay-1)) % 7 == 0) {
                System.out.println();
            }
        }        
        System.out.println();
    }       

    /**
     * Method to get user input for year after validation
     * @return 
     */
    private static int getUserYear() {
        int userYear = 0;
        Scanner input;
        while (true) {
            try {
                input = new Scanner(System.in);
                System.out.print("Enter full year (e.g., 2001): ");
                userYear = input.nextInt();
                return userYear; 
            } 
            catch (Exception e) {
                System.out.println("Non-numeric input.");
            }            
        }
    }

    /**
     * Method to get user input for month after validation
     * @return 
     */
    private static int getUserMonth() {
        int userMonth = 0;
        Scanner input;
        while (true) {
            try {
                input = new Scanner(System.in);
                System.out.print("Enter month in number between 1 and 12: ");
                userMonth = input.nextInt();
                return userMonth; 
            } 
            catch (Exception e) {
                System.out.println("Non-numeric input.");
            }            
        }
    }
} // end DisplayCalendars
