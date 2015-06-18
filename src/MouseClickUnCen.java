

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseClickUnCen extends GraphicsProgram {
	
	public void init(){
		addMouseListeners();
	}

	
	public void mouseClicked(MouseEvent e){
		add(new GImage("Kurec.jpg", e.getX(), e.getY()));
	}
}
