package logic;

import java.util.ArrayList;

public class Grid {
	
	// Variables
	private ArrayList<Row> gridRows;
	private int size;
	
	
	// Constructors
	public Grid(int size) {
		this.size = size;
		this.gridRows = new ArrayList<>();	
	} 
	
	
	// Methods
	public void createGrid() {
		
		for(int rowLoop = 0; rowLoop < getSize(); rowLoop++) {
			Row newRow = new Row(rowLoop);
			
			for(int cellLoop = 0; cellLoop < getSize(); cellLoop++) {
				Cell newCell = new Cell(0, cellLoop, rowLoop);
				newRow.addCellToRow(newCell);
			}
			
			getGridRows().add(newRow);	
		}
	}
	
	public void displayGrid() {

		for(Row row : getGridRows()) {
			System.out.println(row.toString());
		}
		System.out.println("----------------------------");
	}

	
	// Getters & Setters
	public ArrayList<Row> getGridRows() {
		return gridRows;
	}

	public void setGridRows(ArrayList<Row> gridRows) {
		this.gridRows = gridRows;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
