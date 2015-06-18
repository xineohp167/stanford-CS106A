import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class DragObjects extends GraphicsProgram {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(){
		GRect rect = new GRect(100, 100, 150, 100);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
		GOval oval = new GOval(300, 115, 100, 70);
		oval.setFilled(true);
		oval.setColor(Color.GREEN);
		add(oval);
		addMouseListeners();
		addKeyListeners();
	}

	
	/** Checks if there is a object at the point where the mouse is clicked
	 * @see acm.program.Program#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e){
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
	
	public void mouseDragged(MouseEvent e){
		if(gobj!=null){
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	
	public void mouseClicked(MouseEvent e){
		if (gobj!=null) gobj.sendToFront();
		if (gobj!=null && e.getClickCount()==2) gobj.sendToBack();
	}
	
	public void keyPressed(KeyEvent e){
		if (gobj != null){
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:	gobj.move(0, -1); break;
			case KeyEvent.VK_DOWN:	gobj.move(0, 1); break;
			case KeyEvent.VK_RIGHT:	gobj.move(1, 0); break;
			case KeyEvent.VK_LEFT:	gobj.move(-1, 0); break;
			}
		}
	}
	
	// ivars
	private GObject gobj;
	private GPoint last;
}
