
import acm.program.*;

public class AllAsciiSymbols extends ConsoleProgram{
	
	public void run(){
		char[] AllAsciiSym = new char[AllAsciiSymb];
		
		for(int i=0; i<AllAsciiSymb; i++){
			println(i+": "+(char) i);
		}
		
	}
	private static final int AllAsciiSymb = 256;
}
