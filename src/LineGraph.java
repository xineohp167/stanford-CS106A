/*
 * Create a line graph from an array of numbers (monthly average Google stock price?) that scales to the size of the output window.
 */
 
import acm.program.*;
import acm.graphics.*;
 
public class LineGraph extends GraphicsProgram {
 
	private static final long serialVersionUID = 1L;
	double[] stockPrice = {30, 31, 35, 36, 36.5, 37, 37.5, 36, 37, 38.5, 40, 41, 40, 41, 42, 45, 46, 47.5, 44, 43.5, 46, 44.5, 45, 46, 45, 46, 47.5, 49};
	double min = 0;
 
	// Find the distance between points for the x axis and find the factor used to determine the distance for the y axis.
	// Then create the graph.
	public void run() {
		double spacingX = getSpacingWidth(stockPrice);
		double spacingY = getSpacingHeight(stockPrice);
		drawLineGraph(stockPrice, spacingX, spacingY);
	}
 
	// Add each line to the canvas, reassiging endX and endY to be the startX and startY of each new line.
	private void drawLineGraph(double[] array, double spacerX, double spacerY) {
		double startX = MARGIN;
		double startY = getHeight() - MARGIN;
		double endX = 0;
		double endY = 0;
 
		for (int i = 1; i < array.length; i++) {
			GLine line = new GLine(startX, startY, endX, endY);
			endX = MARGIN + i * spacerX;
			endY = ((getHeight() - MARGIN) - (spacerY * (array[i] - min)));
			line.setEndPoint(endX,endY);
			add(line);
			add(new GLabel("+", startX, startY));
			GOval points = new GOval(startX-2, startY-2, 4, 4);
			points.setFilled(true);
			add(points);
 
			startX = endX;
			startY = endY;
		}
	}
 
	// Get the factor needed to determine the placement of y.
	private double getSpacingHeight(double[] array) {
		double max = findMax(array);
		min = findMin(array);
		return (getHeight() - (MARGIN * 2)) / (max - min);
	}
 
	// Find the highest number in the array of stock prices.  This is used to scale the graph to the screen size.
	private double findMax(double[] array) {
		double max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
 
//	 Find the lowest number in the array of stock prices.  This is used to scale the graph to the screen size.
	private double findMin(double[] array) {
		double lowest = 1000000000;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < lowest) {
				lowest = array[i];
			}
		}
		return lowest;
	}
 
	// Find the distance that each line point needs to be from the next so the points can be equal distance on the x axis.
	private double getSpacingWidth(double[] array) {
		return (getWidth() - (MARGIN * 2)) / (array.length-1);
	}
 
	private static final int MARGIN = 5;
}