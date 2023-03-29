package assgn2;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringIndexOutOfBoundsException;

public class Hangman {

	//Main method
	public static void main(String[] args) {
		// Initialization of variables
		String letterString = "abcdefghijklmnopqrstuvwxyz";
		letterString = letterString.toUpperCase();
		char letterChar[] = new char[26];
		letterChar = letterString.toCharArray();
		//System.out.println(letterChar);
		//Initial prompts to User
		System.out.println("----------------------------------");
		System.out.println("\tWelcome to Hangman\t");
		System.out.println("----------------------------------\n");
		System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!\n");
		System.out.println("Other Player - Enter your word (up to 10 letters only, not case sensitive):");
		
		//scan object and various string & int  initializations
		Scanner scanWordObj = new Scanner(System.in);
		String scanWord = scanWordObj.nextLine();
		char scanWordChar[] = new char[scanWord.length()];
		scanWordChar = scanWord.toCharArray();
		System.out.println(scanWordChar);
		
		//Loop to convert character array into all uppercase
		for(int j=0;j<scanWordChar.length;j++)
		{
			scanWordChar[j] = Character.toUpperCase(scanWordChar[j]);	
		}
		System.out.println(scanWordChar);
		
		//Loop to print 20 blank lines
		for(int j=0;j<20;j++)
		{
			System.out.println("\n");
		}
		
		String wordToDate="",scanLetters="",scanWord2="";
		int numberOfChars = scanWordChar.length;
		wordToDate = "*".repeat(numberOfChars);
		scanWord2 = scanWord;
		//counter initialization for while loop
		int i=10;
		System.out.println(numberOfChars);
		
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
		System.out.println("Letters not tried yet: " + letterString);
		System.out.println("Which letter should I check for? ");
		//scan object for letter guessed
		Scanner scanLetterObj = new Scanner(System.in);
		scanLetters = scanLetterObj.nextLine();

		scanLetters = scanLetters.toUpperCase();
		compareArray(scanLetters,scanWordChar);
		
		//scanLetter = scanLetter.substring(0,1);
		
		//condition check if guessed letter is in the initially entered word
		if(scanWord2.contains(scanLetters)){

			//using scanWord2 for masking the guessed letters
			int index = scanWord2.indexOf(scanLetters);
			scanWord2 = scanWord2.replaceFirst(scanLetters, "*");

			wordToDate = wordToDate.substring(0,index) + scanLetters + wordToDate.substring(index+1);
			
			if(!scanWord.contains(scanLetters)) {
			letterString = letterString.replace(scanLetters,"*");
		}}
		else
		{
			System.out.println("--> Not a valid request - either not a letter or already guessed.");
			
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
		
		}}

static void compareArray(String guessStr,char[] scanWordChar)
{
	
	char guessChar[] = new char[guessStr.length()];
	guessChar = guessStr.toCharArray();
	for (int i=0;i<guessChar.length; i++)
	{
		
		char temp = guessChar[i];
		System.out.println(temp);
		for(char c:scanWordChar)
		{
		if(c==temp) {
			c = '*';
			System.out.println("scanwordchar is "+Arrays.toString(scanWordChar));
			//while(true)
			//{
			//	if
			//}
		}
		}
	}
	
	
}
}
	
