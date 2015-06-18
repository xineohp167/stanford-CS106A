package designPatterns;

import acm.graphics.GArc;

/*
 * File: PieChartView.java
 * -----------------------
 * This class represents a concrete implementation of the
 * GraphView class that builds a pie chart.  The details
 * of the implementation are left to you as an exercise.
 */

public class PieChartView extends HousePointsView {

/** Creates a new PieChartView */
	public PieChartView(double width, double height) {
		super(width, height);
	}

/** Arranges pie-shaped wedges around the center of the figure */
	public void createGraph(int[] data) {
		double total = 0;
		double angle = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		for (int i = 0; i < data.length; i++) {
			double sweep = 360 * data[i] / total;
			GArc wedge = new GArc(-CHART_WIDTH / 2, -CHART_HEIGHT / 2, CHART_WIDTH, CHART_HEIGHT, angle, sweep);
			wedge.setFilled(true);
			wedge.setFillColor(getColorForIndex(i));
			add(wedge);
			angle += sweep;
		}
	}
	
	// The size of pie chart
	private static final double CHART_WIDTH = 200;
	private static final double CHART_HEIGHT = 200;

}
