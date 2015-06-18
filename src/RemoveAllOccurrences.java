
/*
 *  RemoveAllOccurrences.java
 *  **********************************
 * @author Fabien
 * This program deletes specified character from a String
 */

import acm.program.*;


public class RemoveAllOccurrences extends ConsoleProgram{
	
	public void run() {
		while (true) {
		String initialString;
			  while(true){
		       initialString = readLine("Enter the string: ");
		       if (initialString.length() != 0) break;
			   }
		String symbol;
		
			while(true){
			
				symbol = readLine("Enter the symbol to be removed from the string: ");
		
					if(symbol.length()==1) break;
			}
		
		char symb = symbol.charAt(0);
		println(removeAllOccurrences(initialString, symb));
		
		  
		}
	}
	
	/**
	 * Deletes specified symbol from a String
	 * @param str the initial string
	 * @param ch  the symbol to be removed
	 * @return    the string without the symbol
	 */
	private String removeAllOccurrences(String str, char ch) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch) {
				result += str.charAt(i);
			}
		}
		
		return result;
		}

}
