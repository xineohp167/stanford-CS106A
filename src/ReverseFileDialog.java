

import acm.program.*;
import acm.util.*;
import acmx.export.java.io.FileReader;
import acmx.export.javax.swing.JFileChooser;

import java.io.*;
import java.util.*;


/**
 * @author Fabien
 * This program reverses the lines in a file
 *
 */
public class ReverseFileDialog extends ConsoleProgram{

	public void run(){
		println("This program reverses the lines in a file.");
		BufferedReader rd = null;
		while(rd==null){
			rd = openFileReaderUsingChooser();
		}
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

	
	private BufferedReader openFileReaderUsingChooser() {
		BufferedReader rd=null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			try{
				File file = chooser.getSelectedFile();
				rd=new BufferedReader(new FileReader(file));
			} catch(IOException ex){
				println("Can't open that file.");
			}
		}
		return rd;
	}
	
}
