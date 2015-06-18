import acm.program.ConsoleProgram;

public class RemoveDoubledLetters extends ConsoleProgram{
	
	public void run(){
		String word = readLine("Enter the word: ");
		
		println(removeDoubledLetters(word));
		println(reverseString(word));
		
	}
   
	private String reverseString(String str) {
		String result = "";
		for (int i = str.length(); i>0; i--) {
		char ch = str.charAt(i-1);
		result += ch;
		}
		return result;
	}

	private String removeDoubledLetters(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
		char ch = str.charAt(i);
		if (i == 0 || ch != str.charAt(i - 1)) {
		result += ch;
		}
		}
		return result;
		}
}
