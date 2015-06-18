
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawLines extends GraphicsProgram {
	
	public void init(){
		addMouseListeners();
	}

	
	public void mousePressed(MouseEvent e){
		line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line);
	}
	
	public void mouseDragged(MouseEvent e){
		line.setEndPoint(e.getX(), e.getY());
	}
	
	
	private GLine line;
}


