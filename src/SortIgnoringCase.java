import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;
import acmx.export.java.io.FileReader;

public class SortIgnoringCase extends ConsoleProgram implements
		Comparator<String> {

	public void run() {
		println("This program sorts a file without regard to case.");
		BufferedReader rd = openFileReader("Enter input file: ");
		List<String> lines = readLineList(rd);
		Collections.sort(lines, this);
		Iterator<String> iterator = lines.iterator();
		while (iterator.hasNext()) {
			println(iterator.next());
		}

	}

	private BufferedReader openFileReader(String string) {
		// TODO Auto-generated method stub
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String name = readLine("Enter a file: ");
				rd = new BufferedReader(new FileReader(name));

			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}

	/**
	 * Reads all available lines from the reader and returns a List<String>
	 * containing those lines. This method closes the reader at the end of the
	 * file.
	 * 
	 * @param rd
	 *            the reader
	 * @return List<String> containing lines from rd.
	 */
	private List<String> readLineList(BufferedReader rd) {
		List<String> lineList = new ArrayList<String>();
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				lineList.add(line);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		return lineList;
	}

	/*
	 * Implements a string comparison method that ignores case. This method
	 * implements the Comparator<String> interface.
	 */
	@Override
	public int compare(String o1, String o2) {

		return o1.toUpperCase().compareTo(o2.toUpperCase());
	}

}
