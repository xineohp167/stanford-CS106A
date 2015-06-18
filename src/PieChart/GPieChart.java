package PieChart;

/*
 * File: GPieChart.java
 * --------------------
 * This file defines a new graphical object type that provides
 * the functionality of a pie chart.
 */

import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class GPieChart extends GCompound {

	/* Constructor: GPieChart(width, height, data) */
	/**
	 * Creates a new pie chart with the specified dimensions for which the pie
	 * slice are determined using the information in <code>data</code>. The
	 * <code>width</code> and <code>height</code> values are typically the same;
	 * using different values here produces an elliptical chart.
	 * 
	 * @usage pieChart = new GPieChart(width, height, data);
	 * @param width
	 *            The width of the pie chart
	 * @param height
	 *            The height of the pie chart
	 * @param data
	 *            An array of <code>double</code> values used to create the
	 *            chart
	 */
	public GPieChart(double width, double height, double[] data) {
		chartWidth = width;
		chartHeight = height;
		setData(data);
	}

	/* Method: setData(data) */
	/**
	 * Sets the information used to create the chart.
	 * 
	 * @usage pieChart.setData(data);
	 * @param data
	 *            An array of <code>double</code> values used to create the
	 *            chart
	 */
	public void setData(double[] data) {
		double total = 0;
		double angle = 0;
		removeAll();
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		for (int i = 0; i < data.length; i++) {
			double sweep = 360 * data[i] / total;
			System.out.println("sweep: " + sweep);
			GArc wedge = new GArc(-chartWidth / 2, -chartHeight / 2,
					chartWidth, chartHeight, angle, sweep);
			System.out.println("width and height: " + getWidth() +" " + getHeight());
			wedge.addMouseListener(new PieChartListener(this, i));
			wedge.setFilled(true);
			Color color = getWedgeColor(i);
			if (data.length > 1 && i == data.length - 1
					&& color == getWedgeColor(0)) {
				color = getWedgeColor(i + 2);
			}
			wedge.setFillColor(color);
			add(wedge);
			angle += sweep;
			System.out.println("angle: " + angle);
		}
	}

	/* Method: getWedgeColor(k) */
	/**
	 * Returns the color to use for wedge segment <code>k</code>. Subclasses can
	 * override this method to choose their own color-selection algorithm.
	 * 
	 * @usage Color color = pieChart.getWedgeColor(k);
	 * @param k
	 *            The index of this pie-chart wedge
	 * @return The color to use for the <code>k</code>th wedge
	 */
	public Color getWedgeColor(int k) {
		return wedgeColors[k % wedgeColors.length];
	}

	/* Private instance variables */
	private static final Color[] wedgeColors = { Color.RED, Color.GREEN,
			Color.BLUE, Color.YELLOW, Color.PINK, Color.CYAN, Color.MAGENTA,
			Color.GRAY, Color.ORANGE };

	private double chartWidth;
	private double chartHeight;
}

/* Package class: PieChartListener */
/**
 * This class listens for mouse clicks in the pie chart and transforms them into
 * action events.
 */

class PieChartListener implements MouseListener {

	/* Constructor: PieChartListener(pieChart, index) */
	/**
	 * Creates a new <code>PieChartListener</code> object.
	 * 
	 * @param pieChart
	 *            The <code>GPieChart</code> to which this listener is attached
	 * @param index
	 *            The index of this wedge
	 */
	public PieChartListener(GPieChart pieChart, int index) {
		target = pieChart;
		actionCommand = "" + index;
	}

	/* MouseListener interface */
	public void mouseClicked(MouseEvent e) {
		ActionEvent ae = new ActionEvent(e.getSource(),
				ActionEvent.ACTION_PERFORMED, actionCommand, e.getModifiers());
		target.fireActionEvent(ae);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	/* Private instance variables */
	private GPieChart target;
	private String actionCommand;

}
