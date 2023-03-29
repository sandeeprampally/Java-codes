package assgn3;

import java.util.Scanner;
import java.util.Arrays;

public class Hangman2 {

	//Main method
	public static void main(String[] args) {
		// Initialization of string and assignment to a character array
		String letterString = "abcdefghijklmnopqrstuvwxyz";
		letterString = letterString.toUpperCase();
		char letterChar[] = new char[26];
		letterChar = letterString.toCharArray();
		//Initial prompts to User
		System.out.println("----------------------------------");
		System.out.println("\tWelcome to Hangman\t");
		System.out.println("----------------------------------\n");
		System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!\n");
		System.out.println("Other Player - Enter your word (up to 10 letters only, not case sensitive):");
		
		//scan object from first user
		Scanner scanWordObj = new Scanner(System.in);
		String scanWord = scanWordObj.nextLine();
		
		//Character array definition for scanned word by first user
		char scanWordChar[] = new char[scanWord.length()];
		scanWordChar = scanWord.toCharArray();
		
		//Loop to convert character array into all uppercase
		for(int j=0;j<scanWordChar.length;j++)
		{
			scanWordChar[j] = Character.toUpperCase(scanWordChar[j]);	
		}
		
		//Loop to print 20 blank lines
		for(int j=0;j<20;j++)
		{
			System.out.println("\n");
		}
		
		//More necessary variables
		String wordToDate="",scanLetters="";
		boolean guessFlag=false;
		int numberOfChars = scanWordChar.length; 
		wordToDate = "*".repeat(numberOfChars);
		char[] wordToDateChar = wordToDate.toCharArray();
		//counter initialization for while loop
		int i=10;
		
		//Condition check for number of characters entered
		if(numberOfChars > 10) {
			System.out.println("Too many characters.Can only take 10.");
		}
		else
		{
		//while loop to iterate for 10 times
		outerloop:
			while(i>0) {
		//defining word to Date and puzzle continuation
		wordToDate = String.valueOf(wordToDateChar);
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
		letterString = String.valueOf(letterChar);
		System.out.println("Letters not tried yet: "+letterString);
		System.out.println("Which letter should I check for? ");
		//scan object for letter guessed and assign to character array
		Scanner scanLetterObj = new Scanner(System.in);
		scanLetters = scanLetterObj.nextLine();
		scanLetters = scanLetters.toUpperCase();
		
		//Calling method to process guess comparisons on actual word
		scanWordChar = compareArray(scanLetters,scanWordChar,letterChar,wordToDateChar);
		
		int counter = 0;
		//Loop to check if all characters are replaced by "*" and show success to user2
		for (char c : scanWordChar) {
		    if (c == '*') {
		    	if(counter == scanWordChar.length-1)
		    		{
		    		System.out.println("Congratulations!\nYou guessed the mystery word \""+scanWord+"\" in "+i+" guesses\nGoodbye....");
			    	guessFlag=true;
			    	break outerloop;
		    		}
		    	counter++;
		    }    
		
		}
		
		    }
		else if(scanYesOrNo.equalsIgnoreCase(Yes)) {
			break;
		}
		else
		{
			System.out.println("invalid input");
		}
		
		
			//System.out.println("--> Not a valid request - either not a letter or already guessed.");
		i--;
		}
		}
		
		//Condition for user failing to guess and display output
		if(!guessFlag){
			System.out.println("print guessFlag "+guessFlag);
			System.out.println("Sorry you didn't find the mystery word!");
			System.out.println("It was "+scanWord +"\nGoodbye...");
		}
		
		}

//Method to implement comparisons on character arrays and return it
static char[] compareArray(String guessStr,char[] scanWordChar,char[] letterChar,char[] wordToDateChar)
{
	
	char guessChar[] = new char[guessStr.length()];
	guessChar = guessStr.toCharArray();
	for (int i=0;i<guessChar.length; i++)
	{
		
		char temp = guessChar[i];
		int index=0;
		//Loop to check each guessed char in character array
		for(char c:scanWordChar)
		{
		if(c==temp) {
			wordToDateChar[index]=Character.toUpperCase(temp);
			scanWordChar[index]='*';
			//Extra loops to modify list of all alphabets
			for(int j=0;j<26;j++)
			{
				if(letterChar[j]==temp)
				{
					letterChar[j]='*';
					for(char d:scanWordChar)
					{
						if(d==temp)
						{
							letterChar[j]=temp;
						}
					}
				}
			}
			break;
		}
		index++;
		}
		
	}
	return scanWordChar;
		
}
}
	
