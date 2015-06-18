/*
 * Generates a ConsoleProgram that uses the sieve of Eratosthenes to generate a list of the primes between 2 and 1000.
 * <a href="http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
">http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
</a> */
 
import acm.program.*;
import java.util.*;
 
public class SieveOfEratosthenes extends ConsoleProgram {
 
	private static final long serialVersionUID = 1L;
 
	private int startPrime = 2;	
	private int[] numList = new int[MAX_NUM + 1];
 
	// Initialize the array with the numbers, find the primes, then print them to the screen.
	public void run() {
		initNumList();
		ArrayList<Integer> primes = findPrimes(numList);
		printPrimes(primes);
	}
 
	// Cycle through the steps of finding the non-prime numbers and removing them.
	private ArrayList<Integer> findPrimes(int[] array) {
		while (startPrime < MAX_NUM) {
			findStartPrime(array);
			removeNonPrimes(array);
		}
		return getOnlyPrimes(array);
	}
 
	// Find the next non-zero number in the array.
	private int findStartPrime(int[] array) {
		for (int i = startPrime; i < MAX_NUM; i++) {
			if (array[i] > 1) {
				startPrime = array[i];
			}
			return startPrime;
		}
		return 0;
	}
 
	// Iterate through the array.  If the number is evenly divisible by the current
	// prime number then it is not a prime number so remove it from the list by overwriting
	// that index of the array to be 0.
	private int[] removeNonPrimes(int[] array) {
		int start = startPrime + 1;
		for (int i = start; i <= MAX_NUM; i++) {
			if (array[i] % startPrime == 0) {
 
				array[i] = 0;
			}
		}
		startPrime += 1;
		return array;
	}
 
	// Take the prime numbers that are scattered in the original array and put them
	// into an ArrayList.  ArrayList is used because we don't know how many primes
	// are in the list so we need to create the list dynamically.
	private ArrayList<Integer> getOnlyPrimes(int[] array) {
		ArrayList<Integer> onlyPrimes = new ArrayList<Integer>();
		for (int i = 0; i <= MAX_NUM; i++) {
			if (array[i] > 1) {
				onlyPrimes.add(array[i]);
			}
		}
		return onlyPrimes;
 
	}
 
	// Print the prime numbers to the screen
	private void printPrimes (ArrayList primes) {
		for (int i = 0; i < primes.size(); i++) {
			int value = (Integer) primes.get(i);
			print(value + " ");
		}
	}
 
	// Generate an array that holds numbers up to the max number
	private int[] initNumList() {
		for (int i = 0; i < MAX_NUM + 1; i++) {
			numList[i] = i;
		}
		return numList;
	}
 
	private static final int MAX_NUM = 1000;
 
}