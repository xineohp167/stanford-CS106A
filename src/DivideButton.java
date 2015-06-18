import java.awt.Component;


class DivideButton extends OperatorButton {
	public DivideButton() { super("/"); }
	
	public int apply(int lhs, int rhs) { 
		if(rhs !=0){
		return lhs/rhs;
		} else return 0;
}
}
