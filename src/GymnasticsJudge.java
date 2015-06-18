
/**
 * @author Fabien
 *	This class reads in an array of scores and computes 
 *	the avarege
 */

import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram{
	
	public void run(){
		int nJudges = readInt("Enter number of judges: ");
		double[] scores = new double[nJudges];
		for(int i=0; i<nJudges; i++){
			scores[i] = readDouble("Score for judge " + i + ": ");
		}
		double total=0;
		for(int i=0; i<nJudges; i++){
			total += scores[i];
		}
		double averageScore = total/nJudges;
		println("The average score is: " + averageScore);
		println("Какво става шефе?");
		println("B" + 8 + 4);
		println("B" + (8 + 4));
		
	}

}
