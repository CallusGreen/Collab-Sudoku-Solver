package logic;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Grid grid = new Grid(9);
		UserInput userInput = new UserInput(scanner);
		Game game = new Game(grid, userInput);
		game.runGame();
	}
}
