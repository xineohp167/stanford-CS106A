import acm.program.*;
import java.util.*;

/*
 This program reads in a list of integers and then displays that list in reverse order.
 This version uses an ArrayList<Integer> to hold the values.
 */

public class ReverseArrayList extends ConsoleProgram {

	// Private constants
	private static final int SENTINEL = 0;

	public void run() {
		println("This program reverses the elements in an ArrayList.");
		println("Use: " + SENTINEL + " to signal the end of the list");
		ArrayList<Integer> list = readArrayList();
		reverseArrayList(list);
		printArrayList(list);

	}

	// Reverses the data in an ArrayList
	private void reverseArrayList(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() / 2; i++) {
			swapElements(list, i, list.size() - i - 1);
		}

	}

	private void swapElements(ArrayList<Integer> list, int p1, int p2) {
		int temp = list.get(p1);
		list.set(p1, list.get(p2));
		list.set(p2, temp);

	}

	// Prints the data from the list, one element per line
	private void printArrayList(ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			int value = (Integer) list.get(i);
			println(value);
		}

	}

	// Reads the data into the list
	private ArrayList<Integer> readArrayList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (true) {
			int value = readInt("?");
			if (value == SENTINEL)
				break;
			list.add(value);
		}
		return list;
	}

}
