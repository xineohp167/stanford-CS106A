

import acm.program.*;
import java.util.*;

public class HashMapExample extends ConsoleProgram{
	
	public void run(){
		setFont("Courier-18");
		
		println("Reading in phone numbers");
		readPhoneNumbers();
		
		println("Looking up phone numbers");
		lookUpNumbers();
		
		println("Displaying Phone numbers");
		displayAllNumbers();
	}

	
	private void displayAllNumbers2(){
		for(String name: phoneBook.keySet()){
			Integer number = phoneBook.get(name);
			println(name + ": " + number);
		}
	}
	
	
	private void displayAllNumbers() {
		Iterator<String> it = phoneBook.keySet().iterator();
		while(it.hasNext()){
			String name = it.next();
			Integer number = phoneBook.get(name);
			println(name+": " + number);
		}
		
	}


	private void lookUpNumbers() {
		while(true){
			String name = readLine("Enter name to lookup: ");
			if(name.equals(""))break;
			Integer number = phoneBook.get(name);
			if(number==null){
				println(name + " not in phoneBook");
			}else{
				println(number);
			}
		}
		
	}


	private void readPhoneNumbers() {
		while(true){
			String name = readLine("Enter name: ");
			if(name.equals("")) break;
			int number = readInt("Phone number (as int): ");
			phoneBook.put(name, number);
		}
		
	}


	// Private instance variables
	private Map<String, Integer> phoneBook = new HashMap<String, Integer>();
}
