

import java.awt.*;

import acm.program.*;
import acm.util.ErrorException;
import acm.util.RandomGenerator;
import acm.graphics.*;

import java.awt.event.*;

public class RandomColorLabel extends GraphicsProgram {
	
	private static final int MAX_LABEL = 7;

	public void init() {
		/* Adds the program as both a MouseListener and MouseMotionListener to the canvas */
		addMouseListeners();
		
		for (int i = 0; i < MAX_LABEL; i++) {
			String labelText = labelName(i);
			GLabel label = new GLabel(labelText);
			label.setColor(ranColor(labelText));
			label.setFont("Impact-30");
			
			/* Make sure label is completely visible */
			double x = rgen.nextDouble(0, getWidth() - label.getWidth());
			double y = rgen.nextDouble(label.getAscent(), getHeight() - label.getDescent());
			add(label, x, y);
		}
	}
	
	/* Call on mouse press */
	public void mousePressed(MouseEvent e) {
		GPoint point = new GPoint(e.getPoint());
		GObject obj = getElementAt(point);
		if (obj instanceof GLabel) {
			GLabel label = (GLabel) obj;
			Color realColor = stringToColor(label.getLabel());
			label.setColor(realColor);
		}
	}
	
	/* Call on mouse release */
	public void mouseReleased(MouseEvent e) {
		GPoint point = new GPoint(e.getPoint());
		GObject obj = getElementAt(point);
		if (obj instanceof GLabel) {
			GLabel label = (GLabel) obj;
			label.setColor(ranColor(label.getLabel()));
		}
	}
	
	private Color stringToColor(String colorName) {
			if (colorName.equals("RED")) {
				return Color.red;
			} else if (colorName.equals("ORANGE")) {
				return Color.orange;
			} else if (colorName.equals("YELLOW")) {
				return Color.yellow;
			} else if (colorName.equals("GREEN")) {
				return Color.green;
			} else if (colorName.equals("CYAN")) {
				return Color.cyan;
			} else if (colorName.equals("BLUE")) {
				return Color.blue;
			} else if (colorName.equals("MAGENTA")) {
				return Color.magenta;
			} else {
				throw new ErrorException("Color out of range.");
			}
	}

	/**
	 * Create a label with the specified color name 
	 * @param j Integer representing one of the 7 colors
	 * @return Name of color as a String
	 */
	private String labelName(int j) {
		switch (j) {
		case 0:
			return ("RED");
		case 1:
			return ("ORANGE");
		case 2:
			return ("YELLOW");
		case 3:
			return ("GREEN");
		case 4:
			return ("CYAN");
		case 5:
			return ("BLUE");
		case 6:
			return ("MAGENTA");
		default :
			throw new ErrorException("Color out of range.");
		}
	}
	
	/**
	 * Returns a random color that is different from the color in the label text.
	 * Example: If the label text is RED, the returned color will be any color but RED.
	 * @param j Integer representing one of the 7 colors
	 * @return Color object that's not the same color as the label
	 */
	private Color ranColor(String label) {
		
		String str = label;
		int colorCode = 0;
		
		while (str.equals(label)) {
			colorCode = rgen.nextInt(0, MAX_LABEL -1);
			str = labelName(colorCode);
			
		}
		
		switch (colorCode) {
		case 0:
			return Color.red;
		case 1:
			return Color.orange;
		case 2:
			return Color.yellow;
		case 3:
			return Color.green;
		case 4:
			return Color.cyan;
		case 5:
			return Color.blue;
		case 6:
			return Color.magenta;
		default :
			throw new ErrorException("Color out of range.");
		}
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
