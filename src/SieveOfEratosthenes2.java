import acm.program.ConsoleProgram;

public class SieveOfEratosthenes2 extends ConsoleProgram{
	public void run() {
		intiNumArray();
		/*We start at 2 since we are trying to find primes between 2 - 1000*/
		int currentPrime = 2; 	
		while (true) {
			currentNumIndexPos = getIndexOf(currentPrime);
			if (!hasMoreValidNumber(currentPrime)) break;
			removeMultiplesFromArray(currentPrime);
			currentPrime = findNextPrime();
		}
		
		printList(numArray);
	}
	
	/*
	 * Print out the list of prime numbers in the array 
	 * @param numArray The array containing the prime numbers
	 */
	private void printList(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -1) {
				println(array[i]);
			}
		}
	}

	/*
	 * Find the next prime number in the array
	 * @return The next prime number in the array.
	 */
	private int findNextPrime() {
		for (int i = currentNumIndexPos + 1; i < numArray.length; i++) {
			if (numArray[i] != -1) {
				return numArray[i];
			}
		}
		return -1;
	}

	/*
	 * Remove the parameter's multiples in the the array 
	 * by replacing the value with -1.
	 * @param currentPrime The prime number to be check for multiples
	 */
	private void removeMultiplesFromArray(int currentPrime) {
		for (int i = currentNumIndexPos + 1; i < numArray.length; i++) {
			if ((numArray[i] % currentPrime) == 0) {
				numArray[i] = -1;
			}
		}
	}

	/*
	 * Check if the array has any more numbers to be tested 
	 * @param startNum The prime number to start checking from
	 * @return true if there are more numbers after the startNum, false if not 
	 */
	private boolean hasMoreValidNumber(int startNum) {
		for (int i = currentNumIndexPos + 1; i < numArray.length; i++) {
			if (numArray[i] != -1) return true;
		}
		return false;
	}

	/*
	 * Find the index value of a value inside an array
	 * @param primeNum The value whose index position we have to find.
	 * @return The Index position of the value.
	 */
	private int getIndexOf(int primeNum) {
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] == primeNum) return i;
		}
		return -1;		// Return -1 if argument passed in is not in the array
	}

	/* Initialize the number array */
	private void intiNumArray() {
		numArray = new int[999];
		int startingValue = 2;
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = startingValue + i;
		}
	}
	
	/*Instance variables*/
	private int currentNumIndexPos;		// Index position of the current prime number
	private int[] numArray;	
}

