
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

import javax.swing.*;

public class DrawingProgram extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

	/* This class is the super class for various palette buttons */
	class PaletteButton extends JButton {

		private static final long serialVersionUID = 1L;

		public PaletteButton(String imgURL, String actionCommand) {
			super();
			ImageIcon icon = new ImageIcon(imgURL);
			setIcon(icon);
			setActionCommand(actionCommand);
			setFocusPainted(true);
			setBorderPainted(false);
			setContentAreaFilled(false);
		}
	}

	/* Initialize the canvas */
	public void init() {
		initPalette();
		drawingTool = "Oval"; // Set default drawing tool to oval
		addActionListeners();
		addMouseListeners();
	}

	/* Initialize the tool palette */
	private void initPalette() {
		PaletteButton ovalBtn = new PaletteButton("images/OvalButton.png",
				"Oval");
		PaletteButton ovalFilledBtn = new PaletteButton(
				"images/OvalFilledButton.png", "OvalFilled");
		PaletteButton rectBtn = new PaletteButton("images/RectangleButton.png",
				"Rectangle");
		PaletteButton rectFilledBtn = new PaletteButton(
				"images/RectangleFilledButton.png", "RectangleFilled");
		PaletteButton lineBtn = new PaletteButton("images/LineButton.png",
				"Line");
		add(ovalBtn, WEST);
		add(ovalFilledBtn, WEST);
		add(rectBtn, WEST);
		add(rectFilledBtn, WEST);
		add(lineBtn, WEST);
	}

	/** Sets the drawing tool to the client's selection */
	public void actionPerformed(ActionEvent e) {
		drawingTool = e.getActionCommand();
	}

	/** Call on mouse pressed */
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		obj = getElementAt(e.getX(), e.getY());
		/*
		 * If there is no element at the coordinate of the mouse press, we
		 * assume that the client wants to draw a shape
		 */
		if (obj == null) {
			if (drawingTool.equals("Rectangle")) {
				drawRect(startX, startY, false);
			} else if (drawingTool.equals("RectangleFilled")) {
				drawRect(startX, startY, true);
			} else if (drawingTool.equals("Oval")) {
				drawOval(startX, startY, false);
			} else if (drawingTool.equals("OvalFilled")) {
				drawOval(startX, startY, true);
			} else if (drawingTool.equals("Line")) {
				drawLine(startX, startY);
			}
		} else {
			last = new GPoint(e.getPoint());
			obj = getElementAt(last);
		}
	}

	/** Call on mouse click to move this object to the front */
	public void mouseClicked(MouseEvent e) {
		obj = getElementAt(e.getX(), e.getY());
		if (obj != null) {
			obj.sendToFront();
		}
	}

	/** Call on mouse release */
	public void mouseReleased(MouseEvent e) {
		obj = null;
	}

	/** Call on mouse drag. */
	public void mouseDragged(MouseEvent e) {
		double mouseX = e.getX();
		double mouseY = e.getY();
		calculateShapeProperties(mouseX, mouseY);
		if (obj != null) {
			obj.move(mouseX - last.getX(), mouseY - last.getY());
			last = new GPoint(e.getPoint());
		} else {
			if (drawingTool.equals("Rectangle")
					|| drawingTool.equals("RectangleFilled")) {
				rect.setLocation(shapeX, shapeY);
				rect.setSize(shapeW, shapeH);
			} else if (drawingTool.equals("Oval")
					|| drawingTool.equals("OvalFilled")) {
				oval.setLocation(shapeX, shapeY);
				oval.setSize(shapeW, shapeH);
			} else if (drawingTool.equals("Line")) {
				line.setEndPoint(mouseX, mouseY);
			}
		}
	}

	/* Draws a line on canvas */
	private void drawLine(double x, double y) {
		line = new GLine(x, y, x, y);
		add(line);
	}

	/* Draws a oval on canvas */
	private void drawOval(double x, double y, boolean fill) {
		oval = new GOval(0, 0);
		oval.setFillColor(Color.magenta);
		oval.setFilled(fill);
		add(oval, x, y);
	}

	/* Draws a rect on canvas */
	private void drawRect(double x, double y, boolean fill) {
		rect = new GRect(0, 0);
		rect.setFillColor(Color.green);
		rect.setFilled(fill);
		add(rect, x, y);
	}

	/*
	 * Calculate the X, Y, width and length of a GRect or GOval relative to the
	 * specified mouse position
	 */
	private void calculateShapeProperties(double mouseX, double mouseY) {

		/* Mouse cursor is in NE region of */
		if (mouseX > startX && mouseY < startY) {
			shapeX = startX;
			shapeY = mouseY;
			shapeW = mouseX - startX;
			shapeH = startY - mouseY;
			/* Mouse cursor is in NW region */
		} else if (mouseX < startX && mouseY < startY) {
			shapeX = mouseX;
			shapeY = mouseY;
			shapeW = startX - mouseX;
			shapeH = startY - mouseY;
			/* Mouse cursor is in SW region */
		} else if (mouseX < startX && mouseY > startY) {
			shapeX = mouseX;
			shapeY = startY;
			shapeW = startX - mouseX;
			shapeH = mouseY - startY;
			/* Mouse cursor is in SE region */
		} else {
			shapeX = startX;
			shapeY = startY;
			shapeW = mouseX - startX;
			shapeH = mouseY - startY;
		}
	}

	private GObject obj;
	private GPoint last;
	private String drawingTool;
	private GLine line;
	private GOval oval;
	private GRect rect;
	private double startX, startY, shapeX, shapeY, shapeW, shapeH;
}
