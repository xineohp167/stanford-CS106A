
import acm.program.*;

/**
 * @author Fabien
 * Creates a table of the letter frequencies in a paragraph
 * of input text terminated by a blank line.
 *
 */
public class CountLetterFrequencies extends ConsoleProgram{
	
	// Private instance variables
	/**
	 * The array stores the letter frequencies
	 */
	private int[] frequencyTable;

	public void run(){
		println("This program counts letter frequencies");
		println("Enter a blank line to terminate");
		initFrequencyTable();
		while(true){
			String line = readLine();
			if(line.length() == 0)break;
			countLetterFrequencies(line);
		}
		printFrequencyTable();
	}
	

	/**
	 *  Displays the frequency table
	 */
	private void printFrequencyTable() {
		for(char ch = 'A'; ch<='Z'; ch++){
			int index = ch-'A';
			println(ch + ": " + frequencyTable[index]);
		}
		
	}


	/**
	 * Counts the letter frequencies in a line of text
	 * @param line
	 */
	private void countLetterFrequencies(String line) {
		for(int i=0; i<line.length(); i++){
			char ch = line.charAt(i);
			if(Character.isLetter(ch)){
				int index = Character.toUpperCase(ch) - 'A';
				frequencyTable[index]++;
			}
		}
		
	}

	/**
	 * Initializes the frequency table to contain zeroes
	 */
	private void initFrequencyTable() {
		frequencyTable = new int[26];
		for(int i=0; i<26; i++){
			frequencyTable[i]=0;
		}
		
	}
	
	

}
