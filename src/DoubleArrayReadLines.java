
import java.io.BufferedReader;
import java.io.IOException;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;
import acmx.export.java.io.FileReader;

/**
 * Reads all available lines from the specified reader and returns an array 
 * containing those lines. This method closes the reader at the end of the file.
 *
 */
public class DoubleArrayReadLines extends ConsoleProgram{
	
	private static final long serialVersionUID = 1L;
	// private constants
	/**  The initial capacity of the array */
	private static final int INITIAL_CAPACITY = 10;
	
	public void run(){
		println("This program reverses the lines in a file.");
		BufferedReader rd = openFileReader("Enter input file: ");
		String[] lines = readLineArray(rd);
		for(int i=lines.length-1; i>=0; i--){
			println(lines[i]);
		}
		
		}
		
		
		/**
		 * @param rd A BufferedReader for the input file
		 * @return A string array containing the lines read from the reader
		 */
		private String[] readLineArray(BufferedReader rd) {
			String[] lineArray = new String[INITIAL_CAPACITY];
			int nLines = 0;
			try{
				while(true){
					String line = rd.readLine();
					if(line==null) break;
					if (nLines + 1 >= lineArray.length){
						lineArray = doubleArrayCapacity(lineArray);
					}
					lineArray[nLines++] = line;
				}
				rd.close();
			} catch(IOException ex){
				throw new ErrorException(ex);
			}
			String[] result = new String[nLines];
			for(int i = 0; i< nLines; i++){
				result[i] = lineArray[i];
			}
			return result;
		}

		
		/**
		 * @param lineArray A string array that has to be doubled
		 * @return A string array with twice as many elements as the old array and
		 *  then copies the existing elements from the old array to the new one
		 */
		private String[] doubleArrayCapacity(String[] lineArray) {
			String[] newArray = new String[2 * lineArray.length];
			for(int i = 0; i < lineArray.length; i++){
				newArray[i] = lineArray[i];
			}
			return newArray;
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
