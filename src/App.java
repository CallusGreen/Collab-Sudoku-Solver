import logic.Game;
import logic.UserInput;
import model.Grid;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		runGameNormal(scanner);
		//runGameWithFileObject(scanner);
	}

	public static Object getObjectFromFile(File file){
		try{
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);

			Object obj = objIn.readObject();
			System.out.println("Object has been read from the file");
			objIn.close();
			return obj;
		} catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	// temporary methods/ refactor later

	public static void runGameWithFileObject(Scanner scanner){
		File file = new File("../Collab-Sudoku-Solver/res/sudoku_grid");
		Grid grid = (Grid) getObjectFromFile(file);
		UserInput userInput = new UserInput(scanner);
		Game game = new Game(grid, userInput);

		game.runGame();
	}

	public static void runGameNormal(Scanner scanner){
		UserInput userInput = new UserInput(scanner);
		Grid grid = new Grid(9);
		Game game = new Game(grid, userInput);

		game.runGame();
	}
}
