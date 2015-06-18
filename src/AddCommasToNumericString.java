/*
 *  AddCommasToNumericString.java
 *  **********************************
 * @author Fabien
 * This program receives an integer and returns this integer with commas on every third 
 * position
 */

import acm.program.*;

public class AddCommasToNumericString extends ConsoleProgram {

	public void run() {
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0)
				break;
			println(addCommasToNumericString(digits));
		}
	}

	/**
	 * returns the numericString in numericString with commas on every third position
	 * @param digits the numericString without commas
	 * @return the numericString with commas
	 */
	private String addCommasToNumericString(String digits) {
		String result = "";
		int len = digits.length();
		int nDigits = 0;
		for (int i = len - 1; i >= 0; i--) {
			result = digits.charAt(i) + result;
			nDigits++;
			if (((nDigits % 3) == 0) && (i > 0)) {
				result = "," + result;
			}
		}
		return result;
	}

}
