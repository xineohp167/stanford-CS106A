
/**
 * @author Fabien
 *This abstract class is the superclass of the various operator buttons.
 *Each concrete subclass must override the apply method
 */
abstract class OperatorButton extends CalculatorButton {
	
	// Creates a new OperatorButton with the specified name
	public OperatorButton(String name){
		super(name);
	}
	
	// Informs the display that this operator button has been clicked
	public void action(CalculatorDisplay display){
		display.setOperator(this);
	}
	
	// Applies this operator (every subclass must implent this method)
	public abstract int apply(int lhs, int rhs);

}
