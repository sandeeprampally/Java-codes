package assgn2;

import java.util.Scanner;
import java.lang.StringIndexOutOfBoundsException;

public class Hangman {

	//Main method
	public static void main(String[] args) {
		// Initialization of variables
		String letter = "abcdefghijklmnopqrstuvwxyz";
		letter = letter.toUpperCase();
		//Initial prompts to User
		System.out.println("----------------------------------");
		System.out.println("\tWelcome to Hangman\t");
		System.out.println("----------------------------------\n");
		System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!\n");
		System.out.println("Other Player - Enter your word (up to 10 letters only, not case sensitive):");
		
		//scan object and various string & int  initializations
		Scanner scanWordObj = new Scanner(System.in);
		String scanWord = scanWordObj.nextLine();
		scanWord = scanWord.toUpperCase();
		String wordToDate="",scanLetter="",scanWord2="";
		int numberOfChars = scanWord.length();
		wordToDate = "*".repeat(numberOfChars);
		scanWord2 = scanWord;
		//counter initialization for while loop
		int i=10;
		
		//Condition check for number of characters entered
		if(numberOfChars > 10) {
			System.out.println("Too many characters.Can only take 10.");
		}
		else
		{
		//while loop to iterate for 10 times
		while(i>0) {
		//Prompts for user on word to Date and puzzle continuation
		System.out.println("Word to date: " + wordToDate + "("+i+") guess(es) left)");
		System.out.println("Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character:");
		//Scan object for Y or N from user
		Scanner scanYesOrNoObj = new Scanner(System.in);
		String scanYesOrNo = scanYesOrNoObj.nextLine();

		
		//String initializations for Y or N
		String Yes = "Y";
		String No = "N";
		//condition check if user enters N
		if(scanYesOrNo.equalsIgnoreCase(No)) {
		System.out.println("Letters not tried yet: " + letter);
		System.out.println("Which letter should I check for? ");
		//scan object for letter guessed
		Scanner scanLetterObj = new Scanner(System.in);
		scanLetter = scanLetterObj.nextLine();

		scanLetter = scanLetter.toUpperCase();
		scanLetter = scanLetter.substring(0,1);
		
		//condition check if guessed letter is in the initially entered word
		if(scanWord2.contains(scanLetter)){

			//using scanWord2 for masking the guessed letters
			int index = scanWord2.indexOf(scanLetter);
			scanWord2 = scanWord2.replaceFirst(scanLetter, "*");

			wordToDate = wordToDate.substring(0,index) + scanLetter + wordToDate.substring(index+1);
			
			if(!scanWord.contains(scanLetter)) {
			letter = letter.replace(scanLetter,"*");
		}}
		else
		{
			System.out.println("--> Not a valid request - either not a letter or already guesses.");
			
		}
		
	
		--i;

		}
		//Else condition if user entered Y
		else if(scanYesOrNo.equalsIgnoreCase(Yes)) {
			break;
		}
		else
		{
			System.out.println("invalid input");
		}
		}
		//Condition check with pattern matching to atleast one character in scanWord2 and word guess complete
		if(!scanWord2.matches(".*[A-Z].*"))
		{
			System.out.println("Congrats! You guessed it right.");
		}
		//Else condition if mystery word is not guessed
		else{
			System.out.println("Sorry you didn't find the mystery word!");
			System.out.println("It was "+scanWord +"\nGoodbye...");
		}
		
		}}}

	

	
