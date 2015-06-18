import acm.program.*;
import acm.util.RandomGenerator;

public class RadixSort extends ConsoleProgram{
	
	// ivars
	private int[] array = new int[10];
	private int[] array2 = {3,20,99,100,0,1,78,25,19,11};
	private RandomGenerator rgen = RandomGenerator.getInstance();
	int rad = 10; // 10 for numbers, 24 for English alphabet
	int digits = 3;
	
	public void run(){
		
		initRandomArray(array);
		printArray(array2);
		radixSort(array2, rad, digits);
		printArray(array2);
		
	}
	
	private void radixSort(int a[],int rad,int max){
        int tmp[][]=new int[a.length][10];

        for(int i=0;i<max;i++){

            int c=0;
            for (int j=0;j<a.length;j++)
                for(int k=0;k<rad;k++)
                    tmp[j][k]=-1;

            for(int k=0;k<a.length;k++){
                int d=(int)((a[k]/Math.pow(10,i))%10);
               
                tmp[k][d]=a[k];
            }

            for (int j=0;j<rad;j++)
                for(int k=0;k<a.length;k++)
                    if(tmp[k][j]!=-1)
                        a[c++]=tmp[k][j];
            
            //printArray(a);
        }

       
    }
	
	private void printArray(int[] anArray) {
		for(int i =0; i<anArray.length; i++){
			print(anArray[i] + "  ");
		}
		println();
		
	}
	
	
	private void initRandomArray(int[] array2) {
		for(int i=0; i<array2.length; i++){
			array2[i]=rgen.nextInt(0, 100);
		}
		
	}

}
