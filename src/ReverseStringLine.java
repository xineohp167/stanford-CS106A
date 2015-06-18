/*ReverseStringLine.java
 ****************************
ReverseStringLine reads String line from console and prints 
the reversed string line.
 */

import acm.program.*;

public class ReverseStringLine extends ConsoleProgram {
	public void run() {
		println("ReverseStringLine reads String line from console and prints the reversed string line");
		String str = readLine("Enter the text: ");
		for (int i = str.length() - 1; i >= 0; i--) {
			print(str.charAt(i));
		}

	}
}