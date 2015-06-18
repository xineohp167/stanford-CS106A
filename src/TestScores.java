/*
This program creates two dimensional array. The dimensions are two and 
user's entered number.

*/
import acm.program.*;

public class TestScores extends ConsoleProgram{
	
	public void run(){
		int numScores = readInt("?");
		scores = new int[2][numScores];
		
		initScores();
		println("Scores[0] before increment");
		printList(scores[0]);
		
		incrementScoreList(scores[0]);
		println("Scores[0] after increment");
		printList(scores[0]);
		
	}

	
	// Prints every element of list on a separate line
	private void printList(int[] is) {
		for(int i=0; i<is.length; i++){
			println(is[i]);
		}
		
	}


	// Adds 1 to every element of list
	private void incrementScoreList(int[] is) {
		for(int i=0; i<is.length; i++){
			is[i]+=1;
		}
		
	}

	// Initialized score grid to all be 0
	private void initScores() {
		for(int i=0; i<scores.length; i++){
			for(int j=0; j<scores[0].length; j++){
				scores[i][j]=0;
			}
		}
		
	}


	// Private instance variables
	private int [][] scores;
}
