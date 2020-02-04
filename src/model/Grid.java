package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable {
	
	// Variables
	private ArrayList<Row> gridRows;
	private int gridSize;
	
	
	// Constructors
	public Grid(int gridSize) {
		this.gridSize = gridSize;
		this.gridRows = new ArrayList<>();
		//createGrid();
	} 
	
	
	// Methods
	public void createGrid() {

		for(int yCoordinateIndex = 0; yCoordinateIndex < this.gridSize; yCoordinateIndex++) {
			Row newRow = new Row();

			for(int xCoordinateIndex = 0; xCoordinateIndex < this.gridSize; xCoordinateIndex++) {
				Cell newCell = new Cell(0, xCoordinateIndex, yCoordinateIndex);
				newRow.addCellToRow(newCell);
			}

			this.gridRows.add(newRow);
		}
	}


	public int getGridSize() {
		return gridSize;
	}

	public Cell getCellFromGrid(int coordinateX, int coordinateY) {
		return this.gridRows.get(coordinateY).getRowOfCells().get(coordinateX);
	}

	public Row getGridRow(int rowNumber){
		return this.gridRows.get(rowNumber);
	}

	public ArrayList<Cell> getGridColumn(int columnNumber){
		ArrayList<Cell> column = new ArrayList<>();
		for(Row r: this.gridRows){
			column.add(r.getRowOfCells().get(columnNumber));
		}
		return column;
	}

	public ArrayList<Row> getGrid(){
		return this.gridRows;
	}

}
