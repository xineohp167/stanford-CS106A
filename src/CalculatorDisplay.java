import java.awt.Font;

import acm.gui.IntField;


/**
 * @author Fabien
 *this class creates the display of the calculator
 */
class CalculatorDisplay extends IntField{
	
	public CalculatorDisplay(){
		setEditable(false);
		setFont(new Font("SansSerif", Font.PLAIN, 24));
		setValue(0);
		startNewValue = false;
		op = null;	
	}
	
	// Adds a digit to the display, clearing the old value if startNewValue is set
	public void addDigit(int digit){
		int value = (startNewValue) ? 0:getValue();
		setValue(10*value+digit);
		startNewValue= false;
	}

	//Sets a new operator, applying the previous one if one exists
	public void setOperator(OperatorButton button){
		if(op==null){
			memory=getValue();
		} else{
			memory=op.apply(memory, getValue());
			setValue(memory);
		}
		op=button;
		startNewValue = true;
	}
	
	
	//Private instance variables
	private OperatorButton op; // The last operator button pressed
	private int memory;		  // The value to which the operator is applied
	private boolean startNewValue; // Set after an operator to start a new value
}
