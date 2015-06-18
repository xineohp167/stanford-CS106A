
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DrawStarMap extends GraphicsProgram{
	
	public void init(){
		setBackground(Color.GRAY);
		add(new JButton("Clear"), SOUTH);
		sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, INITIAL_SIZE);
		add(new JLabel("  Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large  "), SOUTH);
		initColorChooser();
		add(colorChooser, SOUTH);
		addMouseListeners();
		addActionListeners();
		
	}
	
	private void initColorChooser(){
		colorChooser = new JComboBox();
		colorChooser.addItem("White");
		colorChooser.addItem("Red");
		colorChooser.addItem("Yellow");
		colorChooser.addItem("Orange");
		colorChooser.addItem("Green");
		colorChooser.addItem("Blue");
		colorChooser.addItem("Black");
		colorChooser.setEditable(false);
		colorChooser.setSelectedItem("White");
		
	}
	
	/* Returns the current color*/
	private Color getCurrentColor(){
		String name = (String) colorChooser.getSelectedItem();
		if(name.equals("Red")) return Color.RED;
		if(name.equals("Yellow")) return Color.YELLOW;
		if(name.equals("Orange")) return Color.ORANGE;
		if(name.equals("Green")) return Color.GREEN;
		if(name.equals("Blue")) return Color.BLUE;
		if(name.equals("Black")) return Color.BLACK;
		return Color.WHITE;
		
	}

	/* returns the current size */
	private double getCurrentSize(){
		return sizeSlider.getValue();
	}
	
	/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e){
		GStar star = new GStar(getCurrentSize());
		star.setFilled(true);
		star.setColor(getCurrentColor());
		add(star, e.getX(), e.getY());
	}
	
	/* Called whenever an action event occurs */
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Clear")){
			removeAll();
		}
	}
	
	
	/* Private constants */
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 50;
	private static final int INITIAL_SIZE = 16;
	
	
	
	/*
	 * Private ivars
	 */
	private JSlider sizeSlider;
	private JComboBox colorChooser;
}
