/*
Displays how many times the user have clicked.
*/

import acm.graphics.*;
import acm.program.*;

import java.awt.event.MouseEvent;
import java.util.*;

public class GraphicNumbers extends GraphicsProgram{
	
	// Private constants
	private static final double START_X = 50;
	private static final double START_Y = 100;
	
	public void run(){
		addMouseListeners();	
	}
	
	public void mouseClicked(MouseEvent e){
		numClicks++;
		firstLab.setFont("Courier-12");
		firstLab.setLabel("You have clicked: " + numClicks + " times.");
		add(firstLab,10,10);
		
		
		// Create a new label
		GLabel lab = new GLabel("#" + labels.size());
		lab.setFont("Courier-18");
		
		// Move all existing labels one row down
		double dy = lab.getHeight();
		for(int i=0; i<labels.size(); i++){
			labels.get(i).move(0, dy);
		}
		
		add(lab, START_X, START_Y);
		labels.add(lab);
	}
	
	private ArrayList<GLabel> labels = new ArrayList<GLabel>();
	private int numClicks;
	private GLabel firstLab = new GLabel("You have clicked: " + numClicks + " times.");

}
