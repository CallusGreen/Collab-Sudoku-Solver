package logic;

import java.util.ArrayList;

public class Grid {
	
	// Variables
	private ArrayList<Row> grid;
	private int size;
	
	public Grid(int size) {
		this.size = size;
		this.grid = new ArrayList<>();	
	} 
	
	
	// Constructors
	public void createGrid() {
		
		for(int rowLoop = 0; rowLoop < getSize(); rowLoop++) {
			Row newRow = new Row(rowLoop);
			
			for(int cellLoop = 0; cellLoop < getSize(); cellLoop++) {
				Cell newCell = new Cell(0, cellLoop, rowLoop);
				newRow.addCellToRow(newCell);
			}
			
			getGrid().add(newRow);	
		}
	}
	
	
	// Methods
	public void displayGrid() {

		for(Row row : getGrid()) {
			System.out.println(row.toString());
		}
		System.out.println("----------------------------");
	}

	
	// Getters & Setters
	public ArrayList<Row> getGrid() {
		return grid;
	}

	public void setGrid(ArrayList<Row> grid) {
		this.grid = grid;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
