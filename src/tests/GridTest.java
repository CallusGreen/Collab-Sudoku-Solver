package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import logic.Cell;
import logic.Grid;

class GridTest {

	@Test
	void getColumnTest() {
		Grid grid = new Grid(9);
		grid.createGrid();
		
		ArrayList<Cell> expectedColumn = new ArrayList<>();
		
		for(int i = 0; i < 9; i++) {
			Cell cell = new Cell(1, i);
			expectedColumn.add(cell);
		}
		
		ArrayList<Cell> actualColumn = grid.getColumn(grid.getCellFromGrid(1, 0));

		assertTrue(expectedColumn.equals(actualColumn));
	}
	
	@Test
	void getSquareTest() {
		Grid grid = new Grid(9);
		grid.createGrid();
		
		ArrayList<Cell> expectedSquare = new ArrayList<>();
		
		for(int rowLoop=3; rowLoop<6; rowLoop++) {
			for(int colLoop=3; colLoop<6; colLoop++) {
				Cell cell = new Cell(colLoop, rowLoop);
				expectedSquare.add(cell);
			}
		}

		ArrayList<Cell> actualSquare = grid.getSquare(grid.getCellFromGrid(5, 5));

		assertTrue(expectedSquare.equals(actualSquare));
	}
}
