package logic;

import java.util.Scanner;

public class UserInput {

	
	private Scanner scanner; 
	private Integer[] inputs;
	
	
	// Constructor
	public UserInput(Scanner scanner) {
		this.scanner = scanner;
		this.inputs = new Integer[3];
	}
	
	// Prompts user for input, returns user input w/o spaces
	private String takeInput() {
		String input = "";
		System.out.print("Enter your input, it must be 3 numbers: ");
		input = this.scanner.nextLine();
		input = input.replaceAll("\\s", "");
		return input;
	}
	
	// Validates input by making sure it is 3 numbers in the range of 1-9
	private boolean inputIsValid(String input) {
		// Fail Case: input is less than 3
		if(input.length() != 3) {
			return false;
		}
		
		for(int index=0; index<input.length(); index++) {
			// Fail Case: input are not numbers 
			if(!Character.isDigit(input.charAt(index))) {
				return false;
			} 
			else {
				int num = Integer.parseInt(input.charAt(index)+"");
				// Fail Case: input not in range between 1-9
				if(!validateRange(num)) {
					return false;
				}
			}
		}
		return true;
 	}
	
	private boolean validateRange(int num) {
		return (num >=1) && (num<=9);
	}
	
	// Set array to values from user input
	// 	[0] -> x-coordinate
	// 	[1] -> y-coordinate
	// 	[2] -> cell value
	private void setInputs(String input) {
		this.inputs[0] = Integer.parseInt((input.charAt(0) + ""));
		this.inputs[1] = Integer.parseInt((input.charAt(1) + ""));
		this.inputs[2] = Integer.parseInt((input.charAt(2) + ""));
	}
	
	public boolean getUserInput() {
		boolean keepInputting = true;
		String userInput = "";
		while(keepInputting) {
			userInput = this.takeInput();
			if(userInput.equals("-1")) {
				return false;
			}
			
			if(this.inputIsValid(userInput)) {
				setInputs(userInput);
				keepInputting = false;
			}
		}
		return true;
	}
	
	// getter method for Integer[] inputs
	public Integer[] getInputs() {
		return this.inputs;
	}
	
}
