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
	private String takeInputFromUser() {
		displayMessageToUser("Enter your input, it must be 3 numbers: ");

		String usersInput = getScanner().nextLine();
		usersInput = removeWhitespaceFromString(usersInput);

		return usersInput;
	}
	
	public boolean getInputFromUser() {
		boolean keepInputting = true;
		String userInput = "";
		
		while(keepInputting) {
			userInput = takeInputFromUser();
			
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
		return (num >=1) && (num<=9);
	}

	private void setInputs(String input) {
		int xCoordinate = Integer.parseInt((input.charAt(0) + ""));
		int yCoordinate = Integer.parseInt((input.charAt(1) + ""));
		int cellValue = Integer.parseInt((input.charAt(2) + ""));
		
		getInputs()[0] = xCoordinate;
		getInputs()[1] = yCoordinate;
		getInputs()[2] = cellValue;
	}

	public void displayMessageToUser(String message) {
		System.out.println(message);
	}

	public String removeWhitespaceFromString(String string) {
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
