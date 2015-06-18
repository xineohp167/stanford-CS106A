
import acm.program.*;

/**
 * @author Fabien
 * Creates a table of the letter frequencies in a paragraph
 * of input text terminated by a blank line. This version of the program is made to
 * work in Bulgarian. The Bulgarian alphabet is part of the Cyrilic alphabet, but 
 * has 30 letters. While the Cyrilic alphabet works with 32 symbols(the Russian alphabet).
 * So we have to remove two letters with numbers 30(29 in array) and 28(27 in array).
 *
 */
public class CountLetterFrequenciesBG extends ConsoleProgram{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Private instance variables
	private int[] frequencyTable;

	public void run(){
		println("This program counts letter frequencies");
		println("Enter a blank line to terminate");
		initFrequencyTable();
		while(true){
			String line = readLine();
			if(line.length() == 0) break;
			countLetterFrequencies(line);
		}
		printFrequencyTable();
	}
	

	/**
	 *  Displays the frequency table
	 */
	private void printFrequencyTable() {
		for(char ch = 'À'; ch<='ß'; ch++){
			int index = ch-'À';
			if(index!=29 && index!=27){
			println(ch + ": " + frequencyTable[index]);
			}
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
				int index = Character.toUpperCase(ch) - 'À';
				frequencyTable[index]++;
			}
		}
		
	}

	/**
	 * Initializes the frequency table to contain zeroes
	 */
	private void initFrequencyTable() {
		frequencyTable = new int[32];
		for(int i=0; i<32; i++){
			frequencyTable[i]=0;
		}
		
	}
	
	

}
