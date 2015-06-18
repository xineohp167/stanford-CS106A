package PieChart;

/*
 * File: PieChartDemo.java
 * -----------------------
 * This program the use of the GArc class to construct a pie chart.
 */

import acm.graphics.*;
import acm.io.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PieChartDemo extends GraphicsProgram implements ActionListener,
		FocusListener {

	public void init() {
		textField = new JTextField(30);
		textField.setBackground(Color.WHITE);
		textField.addActionListener(this);
		textField.addFocusListener(this);
		add(textField, SOUTH);
		add(new JLabel("   "), SOUTH);
		arcCheckBox = new JCheckBox("Use native arcs");
		arcCheckBox.addActionListener(this);
		add(arcCheckBox, SOUTH);
		textField.setText("3.14, 1.59, 2.65, 3.58");
		chart = new GPieChart(200, 200, new double[0]);
		chart.addActionListener(this);
		setChartData();
		add(chart, getWidth() / 2, getHeight() / 2);
	}

	private void setChartData() {
		StringTokenizer tokenizer = new StringTokenizer(textField.getText(),
				", ");
		ArrayList<Double> values = new ArrayList<Double>();
		while (tokenizer.hasMoreTokens()) {
			values.add(Double.valueOf(tokenizer.nextToken()));
		}
		data = new double[values.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = values.get(i).doubleValue();
		}
		chart.setData(data);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == textField) {
			setChartData();
		} else if (source == arcCheckBox) {
			getGCanvas().setNativeArcFlag(arcCheckBox.isSelected());
			repaint();
		} else if (source instanceof GArc) {
			new IODialog(this).println(data[Integer.parseInt(e
					.getActionCommand())]);
		}
	}

	public void focusGained(FocusEvent e) {
		textField.selectAll();
	}

	public void focusLost(FocusEvent e) {
	}

	private GPieChart chart;
	private JTextField textField;
	private JCheckBox arcCheckBox;
	private double[] data;

	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new PieChartDemo().start(args);
	}
}
