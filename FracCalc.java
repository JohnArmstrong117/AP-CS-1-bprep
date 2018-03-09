package fracCalc;

/*
*****************************************************
* Name: John Armstrong
* AP CS A
* Period 1
* Date: 1/19/2018
* Frac Calc
*****************************************************
*/
import java.util.*;
public class FracCalc {

  public static void main(String[] args) {
	  
	  Scanner input = new Scanner(System.in);
		
		
		int index = 1;
		while(index != 0) {
			System.out.print("Enter Something");
			 String firstPart = input.next();
			 String secondPart = null;
			 String thirdPart = null;
			
			
			if(firstPart.equals("quit")) {
				index = 0;
				System.out.println("Program ended");
			}else {
				 secondPart = input.next();
				 thirdPart = input.next();
				
				//System.out.println(firstPart);
				//System.out.println(secondPart);
				//System.out.println(thirdPart);
			}
			
			int wholeOne = parseWhole(firstPart);
			int wholeTwo = parseWhole(thirdPart);
			int numeOne = parseNume(firstPart);
			int numeTwo = parseNume(thirdPart);
			int denomOne = parseDenom(firstPart);
			int denomTwo = parseDenom(thirdPart);
		
			//System.out.print(wholeOne + " " + wholeTwo + " " + numeOne + " " + numeTwo + " "+ denomOne + " " + denomTwo);
			
			int bigNumeTwo;
			int bigNumeOne;
				
				if(wholeOne > 0) {
					bigNumeOne = (denomOne * wholeOne) + numeOne;
				}else {
					bigNumeOne = numeOne; 
				}
			
				if(wholeTwo > 0) {
					bigNumeTwo = (denomTwo * wholeTwo) + numeTwo;
				}else {
					bigNumeTwo = numeTwo;
				}
			
		//***********************************************************************************
				String answer = " ";
				if(secondPart.equals("+")) {
					answer = add(bigNumeOne, denomOne, bigNumeTwo, denomTwo);
				}else if(secondPart.equals("-")){
					answer = subtract(bigNumeOne, denomOne, bigNumeTwo, denomTwo);
				}else if(secondPart.equals("*")) {
					answer = multiply(bigNumeOne, denomOne, bigNumeTwo, denomTwo);
				}else if(secondPart.equals("/")) {
					answer = divide(bigNumeOne, denomOne, bigNumeTwo, denomTwo);
				}else {
					answer = "scooby doo";
				}
		//************************************************************************************
				
				int answerNume = Integer.parseInt(answer.substring(0, answer.indexOf("/")));
				int answerDenom = Integer.parseInt(answer.substring(answer.indexOf("/") + 1, answer.length()));
				
				if(answerNume % answerDenom == 0) {
					System.out.println(answerNume / answerDenom);
				}else {
					System.out.println(answer);
				}
				
			
		}
		input.close();
	}
  
  
  public static String add(final int firstNume, final int firstDenom,
      final int secondNume, final int secondDenom) {
	
	  //Need an if statement for when the denominator is the same and when it is different
	  if(firstDenom == secondDenom) {
		  int newNume = firstNume + secondNume; //simple math adding the numerators together
		 return newNume + "/" + firstDenom;
	 }else {
		 int newNumeOne = firstNume * secondDenom; //When the denominators are different there is a different process
		 int answerDenom = firstDenom * secondDenom; //the next three lines make a common denominator and 
		 int newNumeTwo = secondNume * firstDenom; //add the numerator together
		 int answerNume = newNumeOne + newNumeTwo;
		 return answerNume + "/" + answerDenom; //returning in fraction form
	 }
  }
  
  public static String subtract(final int firstNume, final int firstDenom,
      final int secondNume, final int secondDenom) {
	 
	  //need an if statement for the same reason as addition
	  if(firstDenom == secondDenom) {
			 int newNume = firstNume - secondNume;//Simple math subtracts the numerators
			 return newNume + "/" + firstDenom;
		 }else {
			 int newNumeOne = firstNume * secondDenom; //different process for when the denominators are different
			 int answerDenom = firstDenom * secondDenom; //next three lines make common denominator and
			 int newNumeTwo = secondNume * firstDenom; //subtract the numerators in order
			 int answerNume = newNumeOne - newNumeTwo;
			 return answerNume + "/" + answerDenom; //returning in fraction form
		 }
  }

  public static String multiply(final int firstNume, final int firstDenom,
      final int secondNume, final int secondDenom) {
	  int newNum = firstNume * secondNume; // Simple math multiplying the numerators together
		int newDen = firstDenom * secondDenom; //Simple math multiplying the denominators together
		return newNum + "/" + newDen;
  }
  
  public static String divide(final int firstNume, final int firstDenom,
      final int secondNume, final int secondDenom) {
	  int newNume = firstNume * secondDenom;//since the second fraction is switched in division
	  int newDenom = firstDenom * secondNume;//I multiply Nume1 and den2 / nume2 and den2
	  return newNume + "/" + newDenom;
	  
  }
  
  
  public static int parseWhole(String input) {
		//if the string contains an underscore it means tat what i want to parse is the number before that
		if(input.contains("_")) {
			int outsideNumber = Integer.parseInt(input.substring(0, input.indexOf("_"))); //parses whole number that comes before '_'
			return outsideNumber;
		//if the string doesn't contain a dash it means there is no fraction so the whole string is the whole number
		}else if(!input.contains("/")) {
			return Integer.parseInt(input); //parses whole number
		}else {
			return 0; //if there is no whole number it returns a 0
		}
	}
	
	public static int parseNume(String input) {
		//if the string contains both '_' and '/' this parses the number between them
		if(input.contains("_") && input.contains("/")) {
			int firstNumber = Integer.parseInt(input.substring(input.indexOf("_") + 1, input.indexOf("/")));//parses "numerator"
			return firstNumber;
		//if there is no whole number the numerator is the first number up to the '/'
		}else if (input.contains("/")) {
			int firstNumber = Integer.parseInt(input.substring(0, input.indexOf("/")));//parses "numerator"
			return firstNumber;
		}else {
			return 0; //if there is no '_' and '/' then the number is the answer
		}
		
	}
	
	public static int parseDenom(String input) {
		//if there is a fraction this parses the denominator
		if(input.contains("/")) {
			int lastNumber = Integer.parseInt(input.substring(input.indexOf("/") + 1, input.length()));//parses evereything after the '/'
			return lastNumber;
		}else {
			return 1; //if there is no fraction the whole number is the answer
		}
	}
	
		
	
}
