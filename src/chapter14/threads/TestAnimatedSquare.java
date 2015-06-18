package chapter14.threads;

import java.awt.Color;

import acm.program.GraphicsProgram;

public class TestAnimatedSquare extends GraphicsProgram{
	
	@Override
	public void run() {
		double x1 = getWidth() / 3 - SQUARE_SIZE / 2;
		double x2 = 2 * getWidth() / 3 - SQUARE_SIZE / 2;
		double y  = (getHeight() - SQUARE_SIZE) / 2;
		AnimatedSquare redSquare = new AnimatedSquare(SQUARE_SIZE);
		redSquare.setFilled(true);
		redSquare.setColor(Color.RED);
		add(redSquare, x1, y);
		AnimatedSquare greenSquare = new AnimatedSquare(SQUARE_SIZE);
		greenSquare.setFilled(true);
		greenSquare.setColor(Color.GREEN);
		add(greenSquare, x2, y);
		Thread redSquareThread = new Thread(redSquare);
		Thread greenSquareThread = new Thread(greenSquare);
		waitForClick();
		redSquareThread.start();
		greenSquareThread.start();
		
	}

	
	// Private constants
	private static final double SQUARE_SIZE = 75;
}
