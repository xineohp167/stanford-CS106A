import java.awt.Component;


class SubtractButton extends OperatorButton {
	public SubtractButton() { super("-"); }
	public int apply(int lhs, int rhs) { return lhs-rhs; }
	
}
