package logic;

public class Game {
	
	// Class Variables
	private Grid grid;
	private UserInput userInput;
	
	
	// Constructor
	public Game(Grid grid, UserInput userInput) {
		this.grid = grid;
		this.userInput = userInput;
	}
	
	
	// Methods
	private void setCellValue(Integer[] inputs) {
		int x = inputs[0];
		int y = inputs[1];
		
		int value = inputs[2];
		
		Row row = getGrid().getGridRows().get(y);
		Cell cell = row.getRow().get(x);
		
		cell.setValue(value);
	}
	
	public void runGame() {
		boolean keepPlaying = true;
		int counter = 0;
		
		getGrid().createGrid();
		
		while(keepPlaying) {
			counter++;
			
			displayMessageToUser("\nMove #" + counter);
			getGrid().displayGrid();
			
			if(getUserInput().getInputFromUser()) {
				setCellValue(getUserInput().getInputs());
				
			} else {
				keepPlaying = false;
			}
		}
		
		displayMessageToUser("Game has ended!");
	}
	
	public void displayMessageToUser(String message){
		System.out.println(message);
	}

	
	// Getters & Setters
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}
}
