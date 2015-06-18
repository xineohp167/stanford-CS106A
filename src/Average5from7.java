import java.text.DecimalFormat;
import acm.program.*;
import java.util.*;

/*
 This program reads the data from 7 judges. Removes the highest and the lowest score
 and gives the average score from the remaining scores.
 */
public class Average5from7 extends ConsoleProgram {
	private static final int numberOfJudges = 7;
	private double[] scores = new double[numberOfJudges];
	private DecimalFormat df = new DecimalFormat("###.#");
	private double sum;
	private double averagedScore;

	public void run() {
		println("Enter the scores from the judges.");
		readScores();
		averagedScore();
		printAveragedScore();
	}

	private void printAveragedScore() {
		println("The averaged score is: " + (df.format(averagedScore)));

	}

	private void averagedScore() {
		Arrays.sort(scores);
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		averagedScore = (sum - scores[0] - scores[scores.length - 1]) / 5.;
	}

	private void readScores() {
		for (int i = 0; i < numberOfJudges; i++) {
			while (true) {
				double judgeScore = readDouble("Enter judge #" + (i + 1)
						+ "'s score: ");
				/* Round to 1 decimal place */
				if (judgeScore >= 0.0 && judgeScore <= 10.0) {
					scores[i] = judgeScore;
					break;
				} else {
					println("Illegal score range.");
				}
			}
		}
	}

}
