package logic;

import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Row> grid;
	private int rowSize, colSize;
	
	public Grid(int rowSize, int colSize) {
		
		this.rowSize = rowSize;
		this.colSize = colSize;
		this.grid = new ArrayList<>();	
	} // end constructor
	
	public ArrayList<Row> getGrid(){
		return this.grid;
	}
	
	public void createGrid(int rowSize, int columnSize) {
	    // outer loop adds rows
		for(int rowLoop=0; rowLoop < rowSize; rowLoop++) {
			Row newRow = new Row(rowLoop);
			
			for(int cellLoop = 0; cellLoop < columnSize; cellLoop++) {
				Cell newCell = new Cell();
				newRow.addCellToRow(newCell);
			}
			
			getGrid().add(newRow);	
		}
	}
	
	public void displayGrid() {
		for(int index=0; index<this.grid.size(); index++) {
			System.out.println(grid.get(index).displayRow());
		}
	}
}
