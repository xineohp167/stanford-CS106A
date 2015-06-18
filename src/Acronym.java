
import acm.program.*;


/**
 * @author Fabien
 *  This program creates a acronym from words entered in console
 *
 */
public class Acronym extends ConsoleProgram {
	
	public void run(){
	
	println("Enter the words");
	String line = readLine();
	println(acronym(line));
	
	}

	/**
	 * returns the acronym from the string
	 * @param str the string
	 * @return the acronym from the string
	 */
	private String acronym(String str) {
		String result;
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		println(str);
		if(str.length()>0){
		 result = str.substring(0, 1);
		
		int pos = str.indexOf(' ');
		//char ch = str.charAt(str.length()-1);
		//if(ch !=' '){
		while(pos != -1 && pos < str.length()-1){
			
			result += str.substring(pos+1, pos+2);

			pos = str.indexOf(' ', pos+1);
		}
		//}
		}else{
			result ="";
		}
		return result;
	}
	
}
