package logic.console;

import gui.ConsoleDisplay;
import logic.MoveValidation;

import java.util.Scanner;

public class ConsoleInputOperations {

	private Scanner scanner;
	private String input;
	// Constructors
	public ConsoleInputOperations(Scanner scanner) {
		this.scanner = scanner;
		this.input = "N/A";
	}

	public String takeUserInput() {
		return MoveValidation.cleanInput(this.scanner.nextLine());
	}

	
	public boolean consoleInputLoop() {
		boolean keepInputting = true;
		String input = "";
		
		while(keepInputting) {
			System.out.println(ConsoleDisplay.userPromptAsString());
			input = takeUserInput();
			
			if(input.equals("-1")) {
				System.out.println(ConsoleDisplay.endGamePromptString());
				return false;
			}

			if(MoveValidation.inputIsValid(input)) {
				this.input = input;
				keepInputting = false;
			}
			else{
				System.out.println(ConsoleDisplay.wrongInputString());
			}
		}
		return true;
	}

	// change program structure to make getInput dependent on whether or not input is validated
	public String getInput(){
		return this.input;
	}
//	public char getUserInput(){
//		return this.scanner.nextLine().toLowerCase().charAt(0);
//	}


//	private void setInputs(String input) {
//		int xCoordinate = Integer.parseInt((input.charAt(0) + ""));
//		int yCoordinate = Integer.parseInt((input.charAt(1) + ""));
//		int cellValue = Integer.parseInt((input.charAt(2) + ""));
//
//		getInputs()[0] = xCoordinate;
//		getInputs()[1] = yCoordinate;
//		getInputs()[2] = cellValue;
//	}

}
