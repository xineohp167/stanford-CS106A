

import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

public class MouseTracker1 extends GraphicsProgram {
	
	private static final double MOUSE_START_POS = 100.0;
	
	public void init() {
		addMouseListeners();
		label = new GLabel("(" + MOUSE_START_POS + "," + MOUSE_START_POS + ")");
		add(label);
	}
	
	public void mouseMoved(MouseEvent e) {
			String labelX = e.getX() + "";
			String labelY = e.getY() + "";
			label.setLabel("(" + labelX + "," + labelY + ")");
			moveLabelToLeftOfMouse(e.getX(), e.getY());
	}
	
	private void moveLabelToLeftOfMouse(double mouseX, double mouseY) {
		label.setLocation(mouseX - label.getWidth(), mouseY);
	}
	
	private GLabel label;
}

