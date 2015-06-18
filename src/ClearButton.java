import java.awt.Component;


/**
 * @author Fabien
 * The ClearButton class resets the calculator by setting the operator to
 * null and the display value to 0. 
 */
class ClearButton extends CalculatorButton {
	public ClearButton(){
		super("C");
	}
	
	public void action(CalculatorDisplay display){
		display.setOperator(null);
		display.setValue(0);
	}
}
