import java.awt.Font;

import javax.swing.JButton;




/**
 * @author Fabien
 * This abstract class i the superclass for every calculator button. Every button 
 * must define an action method, which is called whenever the button is clicked.
 */
abstract class CalculatorButton extends JButton{
	
	// Creates a new CalculatorButton with the specified name
	public CalculatorButton(String name){
		super(name);
		setFont(new Font("SansSerif", Font.PLAIN, 24));
	}
	
	// called when the button is clicked (every subclass must implent this method)
	public abstract void action(CalculatorDisplay display);

}
