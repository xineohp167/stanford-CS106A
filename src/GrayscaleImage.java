import java.awt.event.*;
import acm.graphics.GImage;
import acm.graphics.GMath;
import acm.program.GraphicsProgram;

public class GrayscaleImage extends GraphicsProgram {

	public void run() {
		colorImage = new GImage("parrot.jpg");
		add(colorImage);

		grayscaleImage = createGrayscaleImage(colorImage);

		addMouseListeners();
	}

	private GImage createGrayscaleImage(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];
				int red = (pixel >> 16) & 0xFF;
				int green = (pixel >> 8) & 0xFF;
				int blue = pixel & 0xFF;
				int xx = computeLuminosity(red, green, blue);
				pixel = (0xFF << 24) | (xx << 16) | (xx << 8) | xx;
				array[i][j] = pixel;
			}
		}
		return new GImage(array);
	}

	private int computeLuminosity(int red, int green, int blue) {
		return GMath.round(0.299 * red + 0.587 * green + 0.114 * blue);
	}

	/* Responds to a mouse click */
	public void mouseClicked(MouseEvent e) {
		add(grayscaleImage, colorImage.getWidth() + 10, 0);
	}

	/* Private instance variables */
	private GImage colorImage; /* The image of the initial Rect */
	private GImage grayscaleImage; /* The image of the flip vertical Rect */

	/* Sets the graphics window size */
	public static final int APPLICATION_WIDTH = 900;
	public static final int APPLICATION_HEIGHT = 750;
}