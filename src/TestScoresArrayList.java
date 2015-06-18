

import java.util.ArrayList;

import acm.program.*;

public class TestScoresArrayList extends ConsoleProgram{
	
	public void run(){
		setFont("Courier-24");
		
		int numScores = readInt("?");
		
		initScores(numScores);
		println("Scores before increment");
		printList(scores);
		
		incrementScoreList();
		println("Scores after increment");
		printList(scores);
		
		
	}

	
	private void printList(ArrayList<Integer> scores2) {
		for(int i=0; i< scores2.size(); i++){
			println(scores2.get(i));
		}
		
	}


	private void incrementScoreList() {
		for(int i=0; i<scores.size(); i++){
			scores.set(i, scores.get(i)+1);
		}
		
	}


	private void initScores(int numScores) {
		for(int i=0; i<numScores; i++){
			scores.add(0);
		}
		
	}


	// Private instance variables
	ArrayList<Integer> scores = new ArrayList<Integer>();
}
