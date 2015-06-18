

import acm.program.*;
import acm.util.*;
import acmx.export.java.io.FileReader;

import java.io.*;
import java.util.*;


/**
 * @author Fabien
 * This program reverses the lines in a file
 *
 */
public class ReverseFile extends ConsoleProgram{

	public void run(){
		println("This program reverses the lines in a file.");
		BufferedReader rd = openFileReader("Enter input file: ");
		String[] lines = readLineArray(rd);
		for(int i=lines.length-1; i>=0; i--){
			println(lines[i]);
		}
		
	}

	private String[] readLineArray(BufferedReader rd) {
		ArrayList<String> lineList = new ArrayList<String>();
		try{
			while(true){
				String line = rd.readLine();
				if(line==null) break;
				lineList.add(line);
			}
			rd.close();
		} catch(IOException ex){
			throw new ErrorException(ex);
		}
		String[] result = new String[lineList.size()];
		for(int i = 0; i<result.length; i++){
			result[i] = lineList.get(i);
		}
		return result;
	}

	
	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd=null;
		while(rd==null){
			try{
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader(name));
			
			} catch(IOException ex){
				println("Can't open that file.");
			}
		}
		return rd;
	}
}
