import acm.graphics.GPoint;
import acm.program.ConsoleProgram;




/**
 * This program creates a pattern that simulates the process of winding a piece of colored 
 * yarn around an array of pegs along the edges of the canvas
 *
 */
public class YarnPatternText extends ConsoleProgram{
	public void run(){
		initPegArray();
		
	}
	
	/**
	 * Initializes the array of pegs
	 */
	private void initPegArray(){
		int pegIndex = 0;
		for(int i=0; i<N_ACROSS; i++){
			pegs[pegIndex++] = (i*PEG_SEP);
			//println(pegs[pegIndex]);
			println(pegIndex);
			println(pegs[pegIndex]);
			println(pegs[i]);
		}
		for(int i=0; i<N_DOWN; i++){
			pegs[pegIndex++] = (N_ACROSS*PEG_SEP);
			println(pegIndex);
			println(pegs[pegIndex]);
			println(pegs[i]);
		}
		for(int i=N_ACROSS; i>0; i--){
			pegs[pegIndex++] = (i*PEG_SEP);
			println(pegIndex);
			println(pegs[pegIndex]);
			println(pegs[i]);
		}
		for(int i=N_DOWN; i>0; i--){
			pegs[pegIndex++] = 0;
			println(pegIndex);
			println(pegs[--pegIndex]);
		}
	}
	
	// Private constants
	//private static final int DELTA = 67;
	private static final int PEG_SEP = 10;
	private static final int N_ACROSS = 50;
	private static final int N_DOWN = 30;
	private static final int N_PEGS = 2*N_ACROSS+ 2*N_DOWN;
	
	
	// private ivars
	private int[] pegs = new int[N_PEGS];
	

}
