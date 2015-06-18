import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;
import java.lang.*;

public class SortArrayRandom extends ConsoleProgram{
	
	// ivars
	private int[] array = new int[100];
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run(){
		
		long start = System.currentTimeMillis();
		println(start);
		initRandomArray(array);
		
		
		/*int[] b = (int[])array.clone();
		b = sort(b);*/
		int [] copy = new int[array.length];
	      for ( int idx = 0; idx < array.length; ++idx ) {
	        copy[idx] = array[idx];
	      }
		copy = sort(copy);
		
		for(int i=0; i<array.length; i++){
			 println(copy[i]);
		 }
		
		for(int i=0; i<array.length; i++){
			 println(array[i]);
		 }
		
		long elapsed = System.currentTimeMillis()-start;
		println(elapsed);

}

	 
	 
	 private void initRandomArray(int[] array2) {
		for(int i=0; i<array2.length; i++){
			array2[i]=rgen.nextInt(0, 100);
		}
		
	}



	private int[] sort(int[] sortedArray){
		 int[] result = sortedArray;
		 for(int lh=0; lh< result.length; lh++){
			 int rh = findSmallest(result, lh, result.length);
			 swapElements(result, lh, rh);
		 }
		 
		return result;
	 }

	private void swapElements(int[] array2, int lh, int rh) {
		int temp = array2[lh];
		array2[lh] = array2[rh];
		array2[rh] = temp;
		
	}

	

	private int findSmallest(int[] array2, int lh, int length) {
		int smallestIndex = lh;
		for(int i = lh+1; i<length; i++){
			if(array2[i] < array2[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}

}