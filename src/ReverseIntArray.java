
import acm.program.*;


/**
 * @author Fabien
 * This program reads in an array of five elements of integer and then displays
 * those elements in reverse order 
 */
public class ReverseIntArray extends ConsoleProgram {
	
	// Private Constants
	private static final int N_VALUES = 5; // The length of the array

	public void run(){
		int[] array = new int[N_VALUES];
		println("Enter 5 integers");
		readArray(array);
		reverseArray(array);
		printArray(array);
	}

	/**
	 * Reverses the data in the array
	 * @param array
	 */
	private void reverseArray(int[] array) {
		for(int i=0; i<array.length/2; i++){
			swapElements(array, i, array.length-i-1);
		}
		
	}

	/**
	 * Exchanges two elements in an array
	 * @param array
	 * @param e1
	 * @param e2
	 */
	private void swapElements(int[] array, int e1, int e2) {
		int temp = array[e1];
		array[e1] = array[e2];
		array[e2] = temp;
		
	}

	/**
	 * Prints the data from the array, one per line
	 * @param array
	 */
	private void printArray(int[] array) {
		for(int i=0; i<array.length; i++){
			println(array[i]);
		}
		
	}

	/**
	 * Reads the integers from the console one per line
	 * @param array
	 */
	private void readArray(int[] array) {
		for(int i=0; i<array.length; i++){
			array[i]=readInt("?");
		}
		
	}

}
