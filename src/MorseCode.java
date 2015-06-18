/*
 * This program translates text to Morse Code.
 */
 
import acm.program.*;
 
public class MorseCode extends ConsoleProgram {
 
	private static final long serialVersionUID = 1L;
 
	public void run() {
 
		//Read in a string from the user and convert it to uppercase
		String test = readLine("Enter a string: ");
		String testing = test.toUpperCase();
 
		//For each character, get it's position in the alphabet by subtracting the char A from it.
		for(int i = 0; i < testing.length(); i++) {
			char ch = testing.charAt(i);
			if (Character.isLetter(ch)) {
				int index = Character.toUpperCase(ch) - 'A';
				print(morseCode[index]);
				print(" ");
			//Print white space as is
			} else if (Character.isWhitespace(ch)){
				print(" ");
			}
		}
	}
 
	char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
 
	String[] morseCode = {
			".-", //A
			"-...", //B
			"-.-.", //C
			"-..", //D
			".", //E
			"..-.", //F
			"--.", //G
			"....", //H
			"..", //I
			".---", //J
			"-.-", //K
			".-..", //L
			"--", //M
			"-.", //N
			"---", //O
			".--.", //P
			"--.-", //Q
			".-.", //R
			"...", //S
			"-", //T
			"..-", //U
			"...-", //V
			".--", //W
			"-..-", //X
			"-.--", //Y
			"--.."  //Z
	};
}