package lecture22;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class MyCanvas extends GCanvas implements ComponentListener{

	
	public MyCanvas(){
		addComponentListener(this);
		rect = new GRect(BOX_WIDTH, BOX_HEIGHT);
		rect.setFilled(true);
		
	}
	
	
	private void update() {
		removeAll();
		add(rect, (getWidth() - BOX_WIDTH) / 2, (getHeight() - BOX_HEIGHT) / 2);
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		update();
	}
	@Override
	public void componentHidden(ComponentEvent e) {}
	@Override
	public void componentMoved(ComponentEvent e) {}
	@Override
	public void componentShown(ComponentEvent e) {}
	
	
	/* Private Constants */
	private static final int BOX_HEIGHT = 50;
	private static final int BOX_WIDTH = 50;
	
	/* Private instance variables */
	private GRect rect;

}
