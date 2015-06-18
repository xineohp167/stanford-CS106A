package chapter14.threads;

import acm.graphics.GRect;
import acm.util.RandomGenerator;

public class AnimatedSquare extends GRect implements Runnable {

	// Creates a new AnimatedSquare of the specified size
	public AnimatedSquare(double size) {
		super(size, size);
	}
	
	@Override
	public void run() {
		for (int t = 0; true; t++) {
			if (t % CHANGE_TIME == 0){
				direction = rgen.nextDouble(0, 360);
			}
			movePolar(DELTA, direction);
			pause(PAUSE_TIME);
		}
		
	}
	
	// Private Constants
	private static final double DELTA = 2; // Pixels to move each cycle
	private static final int PAUSE_TIME = 20; // Length of time step
	private static final int CHANGE_TIME = 50; // Steps before changing direction
	
	// Private instance variables
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private double direction;
}
