/*
 * File: CheckWordLadder.java
 * --------------------------
 * Solution for checking a word ladder from the practice final exam.
 */
import java.util.ArrayList;
import java.util.List;

import acm.program.*;

/** Checks to see whether a word ladder is legal */
public class CheckWordLadder extends ConsoleProgram {
	
	/** The list of entered words */
	List<String> words = new ArrayList<String>();
	
	public void run() {
		println("Program to check a word ladder.");
		println("Enter a sequence of words ending with a blank line.");
		while(true){
			String word = readLine();
			if(word.equals("")) break;
			words.add(word);
		}
		if(words.isEmpty()){
			println("You have not entered any words.");
		} else if(words.size() == 1){
			println("You have entered only one word.");
		}else{
			if(isLegalLadder(words)){
				println("Correct!");
			} else{
				println("Wrong!");
			}
		}
		
				
	}

	/**
	 * Method: isLegalLadder(List<String> words) Checks to see if it is legal
	 * to link the words in the list in a word ladder.
	 */
	private boolean isLegalLadder(List<String> words) {
		for (int i = 1; i < words.size(); i++) {
			if(!isLegalLadderPair(words.get(i-1), words.get(i))) return false;
		}
		return true;
	}

	/**
	 * Method: isLegalLadderPair(previous, current) Checks to see if it is legal
	 * to link the two words in a word ladder.
	 */
	private boolean isLegalLadderPair(String previous, String current) {
		if (previous == null)
			return true;
		if (previous.length() != current.length())
			return false;
		return countCharacterDifferences(previous, current) == 1;
	}

	/**
	 * Method: CountCharacterDifferences(s1, s2) Counts the number of character
	 * positions in s1 and s2 that contain different characters.
	 */
	private int countCharacterDifferences(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}

}