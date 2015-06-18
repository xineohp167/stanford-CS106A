
import acm.program.*;
import java.util.*;

/*
This program reads in a list of integers and then displays that list in reverse order.
This version uses an ArrayList as it existed before Java 5.0 and must therefore do its 
own boxing and unboxing.
*/

public class ReverseArrayListPrior5 extends ConsoleProgram{
	
	// Private constants
	private static final int SENTINEL = 0;


	public void run(){
		println("This program reverses the elements in an ArrayList.");
		println("Use: "+ SENTINEL + " to signal the end of the list");
		ArrayList list = readArrayList();
		reverseArrayList(list);
		printArrayList(list);
		
	}

	// Reverses the data in an ArrayList
	private void reverseArrayList(ArrayList list) {
		for(int i=0; i< list.size()/2;i++){
			swapElements(list, i, list.size()- i - 1);
		}
		
	}

	private void swapElements(ArrayList list, int p1, int p2) {
		Object temp = list.get(p1);
		list.set(p1, list.get(p2));
		list.set(p2, temp);
		
	}

	// Prints the data from the list, one element per line
	private void printArrayList(ArrayList list) {
		for(int i=0; i< list.size(); i++){
			Integer valueAsInteger = (Integer) list.get(i);
			println(valueAsInteger.intValue());
		}
		
	}


	// Reads the data into the list
	private ArrayList readArrayList() {
		ArrayList list = new ArrayList();
		while(true){
			int value = readInt("?");
			if(value == SENTINEL) break;
			list.add(new Integer(value));
		}
		return list;
	}

}
