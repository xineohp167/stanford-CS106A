import acm.program.*;

public class DutchNationalFlag extends ConsoleProgram {

	private char[] dutchSymbols = { 'B', 'R', 'B', 'W', 'W', 'B', 'B', 'R',
			'W', 'W', 'R', 'R', 'W', 'R', 'B', 'B' };
	char down = 'R';
	char up = 'B';

	public void run() {
		println("The initial state:");
		printArray(dutchSymbols);
		dutchFlagSort(dutchSymbols, down, up);
	}

	private void printArray(char[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			print(anArray[i]);
		}
		println();

	}

	private void dutchFlagSort(char[] arr, char p, char k) {
		int p_index = 0;
		int k_index = arr.length - 1;
		for (int i = 0; i <= k_index;) {
			if (arr[i] == p) {
				swap(arr, i, p_index);
				p_index++;
				i++;
				println("After swapping positions " + i + " and " + p_index
						+ " :");
				printArray(arr);
			} else if (arr[i] == k) {
				swap(arr, i, k_index);
				k_index--;
				println("After swapping positions " + i + " and " + k_index
						+ " :");
				printArray(arr);
			} else {
				i++;
			}

		}
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
