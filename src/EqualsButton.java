import java.awt.Component;


/**
 * @author Fabien
 * The EqualsButton class displays the current value. As it happens, this 
 *  operation can be implemented simply by setting the operator to null 
 */
class EqualsButton extends CalculatorButton {
	public EqualsButton(){
	super("=");
}

	public void action(CalculatorDisplay display){
		display.setOperator(null);
	}
}
