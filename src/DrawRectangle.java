

import acm.graphics.*;
import acm.program.*;

import java.awt.Color;
import java.awt.event.*;

public class DrawRectangle extends GraphicsProgram {
	
	public void init() {
		addMouseListeners();
	}
	
	/** Add a rectangle to the canvas on mouse press */
	public void mousePressed(MouseEvent e) {
		rect = new GRect(0,0);
		rect.setFillColor(Color.CYAN);
		rect.setFilled(true);
		startX = e.getX();
		startY = e.getY();
		add(rect);
	}
	
	/** Call on mouse drag. Dynamically changes the size of the rectangle according to the location of the mouse pointer */
	public void mouseDragged(MouseEvent e) {
		double mouseX = e.getX();
		double mouseY = e.getY();
		double rectX, rectY, rectW, rectH;
		/* Mouse cursor is in NE region */
		if (mouseX > startX && mouseY < startY) {
			rectX = startX;
			rectY = mouseY;
			rectW = mouseX - startX;
			rectH = startY - mouseY;
		/* Mouse cursor is in  NW region */
		} else if (mouseX < startX && mouseY < startY) {
			rectX = mouseX;
			rectY = mouseY;
			rectW = startX - mouseX;
			rectH = startY - mouseY;
		/* Mouse cursor is in SW region */	
		} else if (mouseX < startX && mouseY > startY) {
			rectX = mouseX;
			rectY = startY;
			rectW = startX - mouseX;
			rectH = mouseY - startY;
		/* Mouse cursor is in SE region */ 
		} else {
			rectX = startX;
			rectY = startY;
			rectW = mouseX - startX;
			rectH = mouseY - startY;
		}
		
		rect.setLocation(rectX, rectY);
		rect.setSize(rectW, rectH);
	}
	
	private GRect rect;
	private double startX, startY;
}
