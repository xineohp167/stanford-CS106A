/*PigLatin.java
***********************
This program reads a line from console in English
and prints this line in Pig Latin

*/

import acm.program.*;
import java.util.*;


public class PigLatin extends ConsoleProgram{
	
	public void run(){
		println("This program translates a line into Pig Latin.");
		String line = readLine("Enter a line:");
		println(translateLine(line));
	}
	
	//Translate a line to PigLatin , word by word
	private String translateLine(String line){
		String result= "";
		StringTokenizer tokenizer = new StringTokenizer(line, DELIMITERS, true);
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			if (isWord(token)) {
				token = translateWord(token);
			}
			result += token;
		}
		return result;
	}
	
	// Translate a word to Pig Latin and returns the translated word
	private String translateWord(String word){
		int vp = findFirstVowel(word);
		if(vp==-1){
			return word;
		} else if (vp==0){
			return word + "way";
		} else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp);
			return tail + head + "ay";
		}
		
	}
	
	// Returns the index of the first vowel in the word (-1 if none)
	private int findFirstVowel(String word){
		for(int i=0; i<word.length(); i++){
			if(isEnglishVowel(word.charAt(i))) return i;
		}
		return -1;
	}
	
	// Returns true if the character is a vowel
	private boolean isEnglishVowel(char ch){
		switch(Character.toLowerCase(ch)){
		case 'a': case'e': case'i': case'o': case'u':
			return true;
			default:
				return false;
		}
	}
	
	// Returns true if token is a word (all characters are letters)
	private boolean isWord(String token){
		for(int i=0; i<token.length(); i++){
			char ch= token.charAt(i);
			if (!Character.isLetter(ch)) return false;
		}
		return true;
	}
	
// Defines the characters that delimit a token
	private static final String DELIMITERS = "!@#$%^&*()_+-*/=[]{};:|||/.,<>? ";
}
