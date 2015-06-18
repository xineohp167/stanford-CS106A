import acm.program.*;

public class InsertionSort extends ConsoleProgram{
	
	private int[] arr = {24, 32, 18, 42, 24, 58};
	
	public void run(){
		println("The array before Insertion Sort:");
		printArray(arr);
		insertionSort(arr);
		println("The array after insertion sort:");
		printArray(arr);
		
		
	}

	private void insertionSort(int[] a) {
		for(int i=1; i<a.length; i++){
			println("i= " + i);
			int temp = a[i];
			println(a[i]); //
			int j;
			for(j=i-1; j>=0 && temp<a[j]; j--){
				println("j= " + j);
				a[j+1] = a[j];
				println(a[j+1]);//
			}
			a[j+1] = temp;
			println(a[j+1]);//
		}
		
	}

	private void printArray(int[] arr2) {
		for(int i=0; i<arr2.length; i++){
			print(arr2[i] + " ");
		}
		println();
		
	}

}
