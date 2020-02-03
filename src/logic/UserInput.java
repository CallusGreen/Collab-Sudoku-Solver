package logic;

import java.util.Scanner;

public class UserInput {

	// Class Variables
	private Scanner scanner; 
	private Integer[] inputs;


	// Constructors
	public UserInput(Scanner scanner) {
		this.scanner = scanner;
		this.inputs = new Integer[3];
	}

	
	// Methods
	private String inputForSudoku() {
		System.out.println("Enter your input, it must be 3 numbers (X Y Value): ");
		System.out.println("Enter -1 to quit");
		String usersInput = getScanner().nextLine();
		usersInput = removeWhitespaceFromString(usersInput);

		return usersInput;
	}
	
	public boolean runInputForSudoku() {
		boolean keepInputting = true;
		String userInput = "";
		
		while(keepInputting) {
			userInput = inputForSudoku();
			
			if(userInput.equals("-1")) {
				return false;
			}

			if(inputIsValid(userInput)) {
				setInputs(userInput);
				keepInputting = false;
			}
		}
		return true;
	}

	public char getUserInput(){
		return this.scanner.nextLine().toLowerCase().charAt(0);
	}

	private boolean inputIsValid(String input) {

		if(inputIsCorrectLength(input) 
				&& inputsAreIntegers(input) 
				&& inputsAreInRange(input)) {
			return true;
		}
		return false;
	}

	public boolean inputIsCorrectLength(String input) {
		boolean inputHasLengthOfThree = input.length() == 3;

		if(inputHasLengthOfThree) {
			return true;
		}

		return false;
	}

	public boolean inputsAreIntegers(String input) {
		for(int index = 0; index < input.length(); index++) {
			boolean charIsInteger = Character.isDigit(input.charAt(index));

			if(!charIsInteger) {
				return false;
			}
		}
		return true;
	}

	public boolean inputsAreInRange(String input) {
		for(int index = 0; index < input.length(); index++) {

			int number = Integer.parseInt(input.charAt(index) + "");
			boolean numberIsInRange = validateRange(number);

			if(!numberIsInRange){
				return false;
			}
		}
		return true;
	}

	private boolean validateRange(int num) {
		return (num >=0) && (num<=9);
	}

	private void setInputs(String input) {
		int xCoordinate = Integer.parseInt((input.charAt(0) + ""));
		int yCoordinate = Integer.parseInt((input.charAt(1) + ""));
		int cellValue = Integer.parseInt((input.charAt(2) + ""));
		
		getInputs()[0] = xCoordinate;
		getInputs()[1] = yCoordinate;
		getInputs()[2] = cellValue;
	}

	private String removeWhitespaceFromString(String string) {
		String updatedString = string;
		updatedString = updatedString.replaceAll("\\s", "");

		return updatedString;
	}

	// Getters & Setters
	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Integer[] getInputs() {
		return inputs;
	}

	public void setInputs(Integer[] inputs) {
		this.inputs = inputs;
	}
}
