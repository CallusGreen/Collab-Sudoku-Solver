package logic;

public class Game {
	private Grid grid;
	private UserInput userInput;
	
	public Game(Grid grid, UserInput userInput) {
		this.grid = grid;
		this.userInput = userInput;
	}
	
	private void setCellValue(Integer[] inputs) {
		int x = inputs[0];
		int y = inputs[1];
		int value = inputs[2];
		Row row = grid.getGrid().get(y);
		Cell cell = row.getRow().get(x);
		cell.setValue(value);
	}
	
	public void runGame() {
		boolean keepPlaying = true;
		int counter = 0;
		this.grid.createGrid();
		
		while(keepPlaying) {
			counter++;
			System.out.println("\nMove #"+ counter);
			this.grid.displayGrid();
			if(userInput.getUserInput()) {
				setCellValue(userInput.getInputs());
			}
			else {
				keepPlaying = false;
			}
		}
		
		System.out.println("Game Has Ended!");
	}
}
