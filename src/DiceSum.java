/*
 * File: DiceSum.java
 * =================================================
 * A program that calculates the sum of n times rolling of a six-sided die
 */

import acm.program.*;
import acm.util.*;

public class DiceSum extends ConsoleProgram {
	
	// Number of rollings
	private static final int NUM_ROLLINGS = 1000000;
	
	public void run() {
		/* Have a large font! */
		setFont("DejaVuSerif-BOLD-24");
		RandomGenerator rgen = RandomGenerator.getInstance();
		int sum =0;
		
		for(int i=0; i<NUM_ROLLINGS; i++) {
			
			int roll = rgen.nextInt(1, 6);
			sum += roll;
		}
		
		println("The sum of " + NUM_ROLLINGS + " rolled dice is " + sum);
	}
}
