

import acm.graphics.*;

/**
 * This class defines a GOval that represent a ball whose reference point is at the center rather than upper left corner 
 */
public class GBall extends GCompound {
	
	/** Creates a new ball with radius r centered at the origin */
	public GBall(double r) {
		GOval ball = new GOval(2 * r, 2 * r);
		ball.setFilled(true);
		add(ball, -r, -r);
		markAsComplete();
	}
	
	/** Creates a new ball with radius centered at (x, y) */
	public GBall(double r, double x, double y) {
		this(r);
		setLocation(x, y);
	}
	
	/** Creates a new ball with radius centered at the coordinates specified in the GPoint object */
	public GBall(double r, GPoint point) {
		this(r);
		setLocation(point.getX(), point.getY());
	}
}

