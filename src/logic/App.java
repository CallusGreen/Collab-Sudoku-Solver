package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		//File file = new File("../Collab-Sudoku-Solver/res/sudoku_grid");
		Scanner scanner = new Scanner(System.in);
		UserInput userInput = new UserInput(scanner);
		Grid grid = new Grid(9);
		//Grid grid = (Grid) getObjectFromFile(file);
		Game game = new Game(grid, userInput);
		
		game.runGame();
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
}
