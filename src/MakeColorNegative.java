import java.awt.event.*;
import acm.graphics.GImage;
import acm.graphics.GMath;
import acm.program.GraphicsProgram;

public class MakeColorNegative extends GraphicsProgram {

	public void run() {
		colorImage = new GImage("StarryNight.jpg");
		add(colorImage);

		colorNegativeImage = createColorNegativeImage(colorImage);

		addMouseListeners();
	}

	private GImage createColorNegativeImage(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];
				int red = (pixel >> 16) & 0xFF;
				int oppositeRed = ~red;
				int green = (pixel >> 8) & 0xFF;
				int oppositeGreen = ~green;
				int blue = pixel & 0xFF;
				int oppositeBlue = ~blue;
				// int xx = computeOppositeColor(red, green, blue);
				pixel = (0xFF << 24) | (oppositeRed << 16)
						| (oppositeGreen << 8) | oppositeBlue;
				array[i][j] = pixel;
			}
		}
		return new GImage(array);
	}

	/*
	 * private int computeOppositeColor(int red, int green, int blue) { return
	 * GMath.round(~red+~green+~blue); }
	 */
	/* Responds to a mouse click */
	public void mouseClicked(MouseEvent e) {
		add(colorNegativeImage, colorImage.getWidth() + 10, 0);
	}

	/* Private instance variables */
	private GImage colorImage; /* The image of the initial Rect */
	private GImage colorNegativeImage; /* The image of the flip vertical Rect */

	/* Sets the graphics window size */
	public static final int APPLICATION_WIDTH = 1100;
	public static final int APPLICATION_HEIGHT = 750;
}