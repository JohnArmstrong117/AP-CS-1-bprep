/*
*****************************************************
* John Armstrong
* AP CS A
* Period 1
* 11/6/2017
* Calendar project
*****************************************************
*/
import java.util.Scanner;
public class calendar {
		public static final int DAYSOFWEEK = 7;
		
		public static void main (String []args) {
		//Promting and getting data for first sunday of the month
			System.out.print("What day is the first sunday?");
				Scanner Inputt1 = new Scanner(System.in);
				int firstSun = Inputt1.nextInt();
		//promting and getting data for days in the month
			System.out.print("How many days are in the month?");
				Scanner Inputt2 = new Scanner(System.in);
				int daysInMonth = Inputt2.nextInt();
			//this variable increments throughout the whole code
				int increment = 1; 
			
			//final method calls next
			topsection();
			/*
			 * calling methods and set increment equal to the return so that it can continue to count up days
			 * also passing needed variables as parameters to use in calculations and the variable increment for printing
			 * the day numbers
			 */
			increment = firstWeek(firstSun, increment);
			increment = blockWeeks(increment);
			finalWeek(increment, daysInMonth);
			bottomline();
		}
		
		//method prints out ascii art line
		public static void bottomline() {
			System.out.println("| ------ | ------ | ------ | ------ | ------ | ------ | ------ |");
		}
		
		//next method prints the top constant part of the calendar
		public static void topsection() {
			System.out.println("   Sun      Mon      Teus     Wed     Thurs     Fri      Sat");
			bottomline();
		}
		
		//next method prints first week
		public static int firstWeek (int firstSun, int increment) {
			//this variable calculates how many spaces are needed in the fist week
			int spaces = (DAYSOFWEEK - firstSun + 1) % 7;
			//for loop prints right number of spaces
			for (int i = 0; i < spaces; i++) {
				System.out.print("|        ");
			}
			//for loop prints the rest of the first week (<7) by printing var increment and then adds to var increment
			for (int j = spaces + 1; j <= DAYSOFWEEK; j++ ) {
				System.out.print("|  " + " " + increment +"    ");
				increment ++;
			}
			System.out.println("|");
			//returning increment var for next method to use
			return increment;
		}
		
		//next method prints out the block weeks in the middle that have no spaces
		public static int blockWeeks(int increment) {
			for(int k = 0; k < 3; k++) {
				for(int l = 0; l < 7; l++) {
					//if else statement to create space formatting inside date boxes
					if(increment < 10) {
						System.out.print("|   " + increment + "    ");
						increment++;
					}else {
						System.out.print("|   " + increment + "   ");
						increment++;
					}
					
				}
				System.out.println("|");
			}
			//returns increment var for next method to use
			return increment;
			
		}
		
		//prints out the last week and gives correct spaces at end
		public static void finalWeek(int increment, int daysInMonth) {
			//for statement to make sure no line overflow
			for(int f = 0; f < DAYSOFWEEK; f++) {
					//if else statement causes spaces to print after the days are done
				if(increment <= daysInMonth) {
					System.out.print("|   " + increment + "   ");
					increment++;
					}else {
						System.out.print("|        ");
				}
			}
				System.out.println("|");
		}
}

