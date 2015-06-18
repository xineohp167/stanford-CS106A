package designPatterns;

/*
 * File: HousePoints.java
 * ----------------------
 * This program displays the house points for the Hogwarts houses
 * in both a bar graph and a pie chart view.  The purpose of the
 * program is to illustrate the model/view/controller pattern
 * described in Chapter 14.  This version, however, is unfinished;
 * completion of the program appears as exercise 7.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.program.*;

public class HousePoints extends GraphicsProgram implements ActionListener {

	/* Instance variables */
	private HousePointsModel model;
	private PieChartView pie;
	private BarGraphView bar;
	private JTextField textField;
	
	public void init(){
		
		/* Initialize the model */
		model = new HousePointsModel();
		
		/* Create views*/
		bar = new BarGraphView(getWidth() / 2, getHeight() / 2);
		pie = new PieChartView(getWidth() / 2 , getHeight() / 2);
		
		/* Add views to model */
		model.addView(bar);
		model.addView(pie);
		
		/* Set up the display. */
		add(new JLabel("Points   "), SOUTH);
		
		textField = new JTextField(30);
		textField.setBackground(Color.WHITE);
		textField.addActionListener(this);
		add(textField, SOUTH);
		
		add(new JLabel("   "), SOUTH);
		
		add(new JButton("Graph"), SOUTH);
		
		// Add views to display
		add(bar, 50, getHeight() / 4);
		add(pie, getWidth() / 1.5, getHeight() / 2);
		
		
		
		/* Ask to receive events. */
		addActionListeners();
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == textField || e.getActionCommand().equals("Graph")) {
			setData();
		}
	}

	/**
	 *  Reads data from textField and adds it to model
	 */
	private void setData() {
		StringTokenizer tokenizer = new StringTokenizer(textField.getText(), ", ");
		ArrayList<Integer> values = new ArrayList<Integer>();
		while (tokenizer.hasMoreTokens()) {
			values.add(Integer.valueOf(tokenizer.nextToken()));
		}
		int[] data = new int[values.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = values.get(i).intValue();
		}
		model.setHousePoints(data);
		
	}
	

}
