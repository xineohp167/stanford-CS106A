import acm.program.*;

public class GuessTheNumber extends ConsoleProgram{
	
	// private instance variable
	private boolean isGuessed = false;
	private String answer;
	// the boundaries
	private int lh =0;
	private int rh=100;
	
	public void run(){
		println("Think of a number between " + lh + " and " + rh +" .");
		
		
			while(lh<=rh){
				int mid = (lh+rh)/2;
				int cmp = checkIt(mid);
				if(cmp==0){
					isGuessed=true;
					break;
				}
				if(cmp<0){
					rh = mid-1;
				} else{
					lh = mid+1;
				}
			}
			
			if(isGuessed==true){
				println("I guessed the number");
			} else{
				println("You are cheating!");
			}
	
			
	}

	private int checkIt(int mid) {
		answer = readLine("Is it: " + mid);
		if(answer.equalsIgnoreCase("Yes")){
			return 0;
		} else{
			String askForLess = readLine(" Is it less than: " + mid);
			if(askForLess.equalsIgnoreCase("Yes")){
				return -1;
			}else{
				return +1;
			}
		}
		
		
	}

	
}
