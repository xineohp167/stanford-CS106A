import java.awt.Component;


class DigitButton extends CalculatorButton {
	
	// Creates a new DigitButton for the digit n
	public DigitButton(int n){
		super("" + n);
	}
	
	// Adds this digit to the display
	public void action(CalculatorDisplay display){
		display.addDigit(Integer.parseInt(getText()));
	}

}
