
import javax.swing.JButton;

import acm.gui.TableLayout;
import acm.program.Program;



public class TableLayoutExample extends Program{
	public void init(){
		setLayout(new TableLayout(2,3));
		add(new JButton("Button 1"));
		add(new JButton("Button 2"));
		add(new JButton("Button 3"));
		add(new JButton("Button 4"));
		add(new JButton("Button 5"));
		add(new JButton("Button 6"));
		
	}

}