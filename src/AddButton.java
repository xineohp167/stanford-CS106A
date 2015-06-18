import java.awt.Component;


class AddButton extends OperatorButton {
 public AddButton(){ super("+"); }
 public int apply(int lhs, int rhs) { return lhs + rhs;}
 
}
