import java.awt.event.*;
import acm.graphics.GImage;
import acm.graphics.GMath;
import acm.program.GraphicsProgram;

public class AvaragingFilter extends GraphicsProgram {

	public void run() {
		roughImage = new GImage("rough.jpg");
		add(roughImage);
		filteredImage = applyAveragingFilter(roughImage);

		for (int i = 0; i < 100; i++) {
			filteredImage = applyAveragingFilter(filteredImage);
		}
		addMouseListeners();
	}

	private GImage applyAveragingFilter(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int xx = averageNeighborLuminosity(array, i, j);
				array[i][j] = (0xFF << 24) | (xx << 16) | (xx << 8) | xx;
			}
		}
		return new GImage(array);
	}

	private int averageNeighborLuminosity(int[][] array, int i, int j) {
		int sum = getLuminosity(array, i, j);
		int count = 1;
		if (i > 0) {
			sum += getLuminosity(array, i - 1, j);
			count++;
		}
		if (i < array.length - 1) {
			sum += getLuminosity(array, i + 1, j);
			count++;
		}
		if (j > 0) {
			sum += getLuminosity(array, i, j - 1);
			count++;
		}
		if (j < array[0].length - 1) {
			sum += getLuminosity(array, i, j + 1);
			count++;
		}
		return GMath.round((double) sum / count);
	}

	private int getLuminosity(int[][] array, int i, int j) {
		int pixel = array[i][j];
		int red = (pixel >> 16) & 0xFF;
		int green = (pixel >> 8) & 0xFF;
		int blue = pixel & 0xFF;
		return GMath.round(0.299 * red + 0.587 * green + 0.114 * blue);
	}

	/* Responds to a mouse click */
	public void mouseClicked(MouseEvent e) {
		add(filteredImage, roughImage.getWidth() + 10, 0);
	}

	/* Private instance variables */
	private GImage roughImage; /* The image of the initial Rect */
	private GImage filteredImage; /* The image of the flip vertical Rect */

	/* Sets the graphics window size */
	public static final int APPLICATION_WIDTH = 1500;
	public static final int APPLICATION_HEIGHT = 750;
}