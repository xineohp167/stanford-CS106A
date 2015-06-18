import java.awt.event.*;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class FlipVertical extends GraphicsProgram {

	public void run() {
		rect1 = new GImage("TwoRects.jpg");
		add(rect1);

		flipVerticalRect = flipVertical(rect1);

		addMouseListeners();
	}

	private GImage flipVertical(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		for (int p1 = 0; p1 < height / 2; p1++) {
			int p2 = height - p1 - 1;
			int[] temp = array[p1];
			array[p1] = array[p2];
			array[p2] = temp;
		}
		return new GImage(array);
	}

	/* Responds to a mouse click */
	public void mouseClicked(MouseEvent e) {
		add(flipVerticalRect, rect1.getWidth() + 10, 0);
		add(flipVertical(flipVerticalRect), flipVertical(flipVerticalRect)
				.getWidth() * 2 + 20, 0);
	}

	/* Private instance variables */
	private GImage rect1; /* The image of the initial Rect */
	private GImage flipVerticalRect; /* The image of the flip vertical Rect */

	/* Sets the graphics window size */
	public static final int APPLICATION_WIDTH = 900;
	public static final int APPLICATION_HEIGHT = 750;
}