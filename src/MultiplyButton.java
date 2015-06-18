import java.awt.Component;


class MultiplyButton extends OperatorButton {
	public MultiplyButton() { super("x"); }
	public int apply(int lhs, int rhs) { return lhs * rhs; }
	
}
