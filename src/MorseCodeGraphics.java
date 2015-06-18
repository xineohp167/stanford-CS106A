/*
 * This program converts user entered text into Morse Code using graphics
 */
 
import java.awt.event.ActionEvent;
import javax.swing.*;
import acm.program.*;
import acm.graphics.*;
 
public class MorseCodeGraphics extends GraphicsProgram {
 
	private static final long serialVersionUID = 1L;
 
	// Set the canvas
	public void run() {
		textField = new JTextField(MAX_TEXT);
		textField.addActionListener(this);
		add(new JLabel("Enter text  "), NORTH);
		add(textField, NORTH);
		addKeyListeners();
	}
 
	// Convert the user entered text into morse code
	private void convertToMorseCode(String text) {
		int x = 10;
		int y = 10;		
		//For each character, get it's position in the alphabet by subtracting the char A from it.
		for(int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (Character.isLetter(ch)) {
				int index = Character.toUpperCase(ch) - 'A';
 
				// Now get the Morse code for that character
				String code = morseCode[index];
 
				// Iterate through each character in the word and print out a circle or rectangle
				for (int j = 0; j < code.length(); j++) {
					char codeChar = code.charAt(j);
					String dotOrDash = Character.toString(codeChar);
					// If the character is a dot, add a circle graphic and set x for the next graphic
					if (dotOrDash.toString().equals(".")) {
						GOval circle = new GOval(5, 5);
						circle.setFilled(true);
						add(circle, x, y);
						x += 10;
					//If  the character is a dash, add a rectangle graphic and set x for the next graphic
					} else {
						GRect rect = new GRect(10, 5);
						rect.setFilled(true);
						add(rect, x, y);
						x += 15;
					}
				}
				// End of the Morsecode for this char so add some space before the next piece of code
				x += 20;
			//Readjust the x and y position for the next word
			} else if (Character.isWhitespace(ch)){
				y += 20;
				x = 10;
			}
		}
	}
 
	// Implementation of actionPerformed for the keylistener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textField) {
			convertToMorseCode(textField.getText());
		}
	}
 
	private JTextField textField;
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
			"--.."
	};
	private static final int MAX_TEXT = 50;
}