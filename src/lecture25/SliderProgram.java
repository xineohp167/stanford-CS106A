package lecture25;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;


public class SliderProgram extends GraphicsProgram{
	
	public void run(){
		add(new JButton("Slide"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if(cmd.equals("Slide")){
			// create a new slider
			Slider slider = new Slider(SIZE, rgen.nextColor());
			add(slider, 0, rgen.nextDouble(0, 300));
			
			// run the slider on a new thread
			Thread sliderThread  = new Thread(slider);
			sliderThread.start();
		}
	}
	
	/* constants */
	private static final int SIZE = 20;
	
	/* private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
