package logic;

import model.Cell;
import model.Grid;
import model.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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
			
			if(getUserInput().runInputForSudoku()) {
				setCellValue(getUserInput().getInputs());
			}
			else {
				System.out.print("Do you want to save this board to file? Enter Yes or No ");
				char response = this.userInput.getUserInput();
				if(response == 'y'){
					saveGridToFile();
				}
				keepPlaying = false;
			}
		}
		
		displayMessageToUser("Game has ended!");
	}

	public void runGameWithObject() {
		boolean keepPlaying = true;
		int counter = 0;

		//getGrid().createGrid();

		while(keepPlaying) {
			counter++;

			displayMessageToUser("\nMove #" + counter);
			getGrid().displayGrid();

			if(getUserInput().runInputForSudoku()) {
				setCellValue(getUserInput().getInputs());
			}
			else {
				System.out.print("Do you want to save this board to file? Enter Yes or No ");
				char response = this.userInput.getUserInput();
				if(response == 'y'){
					saveGridToFile();
				}
				keepPlaying = false;
			}
		}

		displayMessageToUser("Game has ended!");
	}

	private void saveGridToFile(){
		File file = new File("../Collab-Sudoku-Solver/res/sudoku_grid");

		try{
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream outObj = new ObjectOutputStream(out);
			outObj.writeObject(this.grid);
			outObj.close();
			System.out.println("The object was written to file");
		} catch (Exception e){
			e.printStackTrace();
		}
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
