

/* 
 * File: BouncingBall.java 
 * ----------------------- 
 * This program graphically simulates a bouncing ball with gravity.
 * Using algorithm from http://www.learningprocessing.com/examples/chapter-5/example-5-9/
 *   
 */
import acm.program.*;
import acm.graphics.*;

public class BouncingBallGravity extends GraphicsProgram {

	/** Size (diameter) of the ball */
	private static final int DIAM_BALL = 30;

	/**
	 * The gravity constant
	 */
	private static final double GRAVITY = 0.1;

	/** Animation delay or pause time between ball moves */
	private static final int DELAY = 50;

	/** Initial X and Y location of ball */
	private static final double X_START = DIAM_BALL / 2;
	private static final double Y_START = 100;

	/** X Velocity */
	private static final double X_VEL = 0;//5;

	/** Amount Y Velocity is reduced when it bounces */
	private double BOUNCE_REDUCE = -0.75;

	/** Starting X velocity */
	private double xVel = X_VEL;
	/** Starting Y velocity */
	private double yVel = 0.0;
	/** Starting X position */
	private double xPos = X_START;
	/** Starting Y position */
	private double yPos = Y_START;

	/* private instance variable */
	private GOval ball;
	private boolean isRunnable  = true;

	public void run() {
		setup();

		// Simulation ends when ball goes off right hand
		// end of screen
		while (isRunnable) {
			// Add speed to location.
			yPos += yVel;
			// Add gravity to speed.
			yVel += GRAVITY;
			
			ball.move(0, yVel);
			// If square reaches the bottom
			// Reverse speed
			if(ball.getY() > (getHeight() - DIAM_BALL)){
				//isRunnable = false;
				yVel *= BOUNCE_REDUCE;
				// x2 = x2+0.01* gravity;
				BOUNCE_REDUCE = BOUNCE_REDUCE + 0.01 * GRAVITY;
				yPos = getHeight()-DIAM_BALL;
				ball.move(0, getHeight() - DIAM_BALL - ball.getY());
				//ball.move(0, yVel);
				System.out.println(yVel + "--" + BOUNCE_REDUCE);
			}
			// For free falling and Vx = 0
			// If BOUNCE_REDUCE < 0.6 stop calculations
			if(Math.abs(BOUNCE_REDUCE) < 0.6){
				isRunnable = false;
			}
			
			//moveBall();
			//checkForCollision();
			pause(DELAY);
		}
	}

	/** Create and place ball. */
	private void setup() {
		ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
		ball.setFilled(true);
		add(ball);
	}

	/** Update and move ball */
	/*private void moveBall() {
		// increase yVelocity due to gravity on each cycle
		yVel += GRAVITY;
		ball.move(xVel, yVel);
	}*/

	/**
	 * Determine if collision with floor, update velocities and location as
	 * appropriate.
	 */
	/*private void checkForCollision() {
		// determine if ball has dropped below the floor
		if (ball.getY() > getHeight() - DIAM_BALL) {

			// change ball's Y velocity to now bounce upwards
			yVel = -yVel * BOUNCE_REDUCE;

			// assume bounce will move ball an amount above the
			// floor equal to the amount it would have dropped
			// below the floor.
			double diff = ball.getY() - (getHeight() - DIAM_BALL);
			ball.move(0, -2 * diff);
		}
	}*/
}
