package lecture25;



import java.awt.Color;

import acm.graphics.GRect;

/*
 * File: Slider.java
 * ------------------------------------
 * This class is an example of a runnable class
 * that animates a square sliding across the screen
 */

public class Slider extends GRect implements Runnable{

	public Slider(int size, Color color) {
		super(size, size);
		setFilled(true);
		setColor(color);

	}

	@Override
	public void run() {
		// animate a slide across the screen
		for(int i = 0; i < 1000/STEP; i++){
			pause(40);
			move(STEP, 0);
		}
		
	}
	
	/* constants */
	private static final double STEP = 5;

}
