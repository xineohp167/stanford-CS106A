/*
 * This program flips an image horizontally.
 */
 
import acm.graphics.*;
import acm.program.*;
 
public class FlipHorizontal extends GraphicsProgram {
 
	private static final long serialVersionUID = 1L;
 
	GImage image = new GImage("CT.jpg");
 
	// Add the flipped image to the canvas.
	public void run() {
		add(image, 10, 100);
		add(flipHorizontal(image), image.getWidth(), 100);
	}
 
	// Iterate through each pixel of the (row by row) and swap it with the corresponding
	// pixel on the opposite side of the picture.
	private GImage flipHorizontal(GImage anImage) {
		int[][] array = anImage.getPixelArray();
		int height = array.length;
		int width = array[0].length;
 
		// Swapping the pixels - first assign the current pixel to a temp spot.  Transfer
		// the pixel from right side of the picture to the left.  Then assign the temp
		// pixel to the pixel on the right.
		for (int y = 0; y < height; y++) {
			for (int x1 = 0; x1 < width / 2; x1++) {
				int x2 = width - x1 - 1;
				int temp = array[y][x1];
				array[y][x1] = array[y][x2];
				array[y][x2] = temp;
			}
		}
		return new GImage(array);
	}
}
 