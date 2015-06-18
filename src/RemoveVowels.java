

import acm.program.*;
import acmx.export.java.io.FileReader;

import java.io.*;



/**
 * Reads a text file and write the text without vowels in other file
 *
 */
public class RemoveVowels extends ConsoleProgram {
	
	public void run(){
		
		println("To operate the program you have to have\na file called RemoveVowels");
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("RemoveVowels.txt"));
			PrintWriter wr = new PrintWriter(new FileWriter("WithoutVowels.txt"));
			
			while(true){
				String line = rd.readLine();
				if(line==null)break;
				wr.println(removeVowels(line));
			}
			wr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private String removeVowels(String line) {
		String result ="";
		for(int i =0; i<line.length(); i++){
			char ch = line.charAt(i);
			if(!isVowel(ch)){
				result += ch;
			}
		}
		return result;
	}

	private boolean isVowel(char ch) {
		switch(Character.toLowerCase(ch)){
		case 'a': case 'e': case 'u': case 'o': case 'i': 
			return true;
			default:
				return false;
		}
	}

	

}
