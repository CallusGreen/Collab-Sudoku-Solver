package logic.console;

import gui.ConsoleDisplay;
import logic.console.ConsoleInputOperations;
import model.Cell;
import model.Grid;
import model.PlayerMove;
import model.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class RunGameInConsole {
	
	// Class Variables
	private Grid grid;
	private Scanner scanner;
	private ConsoleInputOperations inputter;
	
	// Constructor
	public RunGameInConsole(Grid grid, Scanner scanner) {
		this.grid = grid;
		this.scanner = scanner;
		this.inputter = new ConsoleInputOperations(this.scanner);
	}
	
	
	// Methods
	private void setCellValue(HashMap<String, Integer> move) {
		int x = move.get("X");
		int y = move.get("Y");
		
		int value = move.get("Value");
		
		Row row = this.grid.getGrid().get(y);
		Cell cell = row.getRowOfCells().get(x);
		
		cell.setValue(value);
	}

	public void runGame(){
		PlayerMove move;
		boolean keepPlaying = true;
		this.grid.createGrid();

		while(keepPlaying){
			ConsoleDisplay.displayGame(this.grid);

			if(this.inputter.consoleInputLoop()){
				move = new PlayerMove(this.inputter.getInput());
				setCellValue(move.getMoveMap());
			}

			else {
				System.out.print("Do you want to save this board to file? Enter Yes or No ");
				char response = this.inputter.takeUserInput().toLowerCase().charAt(0);
				if(response == 'y'){
					saveGridToFile();
				}
				keepPlaying = false;
			}
		}

		System.out.println("Game has ended!");
	}
	

//	public void runGameWithObject() {
//		boolean keepPlaying = true;
//		int counter = 0;
//
//		//getGrid().createGrid();
//
//		while(keepPlaying) {
//			counter++;
//
//			displayMessageToUser("\nMove #" + counter);
//			getGrid().displayGrid();
//
//			if(getConsoleInputOperations().runInputForSudoku()) {
//				setCellValue(getConsoleInputOperations().getInputs());
//			}
//			else {
//				System.out.print("Do you want to save this board to file? Enter Yes or No ");
//				char response = this.ConsoleInputOperations.getUserInput();
//				if(response == 'y'){
//					saveGridToFile();
//				}
//				keepPlaying = false;
//			}
//		}
//
//		displayMessageToUser("Game has ended!");
//	}

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
}
