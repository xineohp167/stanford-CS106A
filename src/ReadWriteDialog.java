

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
public class ReadWriteDialog extends ConsoleProgram{
	
	// private ivars
	private BufferedReader rd;
	private PrintWriter wr;

	public void run(){
		println("This program reads the text from a file and writes the mirrored text in another file.");
		rd = null;
		while(rd==null){
			rd = openFileReaderUsingChooser();
		}
		String[] lines = readLineArray(rd);
		wr = null;
		while(wr==null){
			wr = savePrintWriterUsingChooser();
		}
		
		printMirroredText(lines, wr);
		
		
		/*for(int i=lines.length-1; i>=0; i--){
			println(lines[i]);
		}*/
		
	}

	private void printMirroredText(String[] lines, PrintWriter wr2) {
		for(int h=0; h<lines.length; h++){
			for(int i=lines[h].length()-1; i>=0; i--){
			wr2.print(lines[h].charAt(i));
		}
			wr2.println();
		}
		wr2.close();
		
	}

	private PrintWriter savePrintWriterUsingChooser() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			try{
				File file = chooser.getSelectedFile();
				wr=new PrintWriter(new FileWriter(file));
			} catch(IOException ex){
				println("Can't open that file.");
			}
		}
		return wr;
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
