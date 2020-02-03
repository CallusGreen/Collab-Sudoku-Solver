package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable {
	
	// Variables
	private ArrayList<Row> gridRows;
	private int size;
	
	
	// Constructors
	public Grid(int size) {
		this.size = size;
		this.gridRows = new ArrayList<>();	
	} 
	
	
	// Methods
	
	//Potentially put this method into constructor as one is never used without the other?
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
	
	public ArrayList<Cell> getColumn(Cell cell){
		ArrayList<Cell> column = new ArrayList<>();
		
		for(Row row : getGridRows()) {
			Cell columnCell = row.getRow().get(cell.getXCoordinate());
			column.add(columnCell);
		}
		
		return column;
	}

	public ArrayList<Cell> getColumn(int columnNumber){
		ArrayList<Cell> column = new ArrayList<>();
		for(Row r: this.gridRows){
			column.add(r.getRow().get(columnNumber));
		}
		return column;
	}
	
	// Horrible, brute-force method that needs to be made into algorithm
	public ArrayList<Cell> getSquare(Cell cell){
		ArrayList<Cell> square = new ArrayList<>();
		
		int cellRow = cell.getYCoordinate();
		int cellCol = cell.getXCoordinate();
		
		int squareRowNum = 0;
		int squareColNum = 0;
		int startingRowNum = 0;
		int startingColNum = 0;
		
		if(cellRow == 0 || cellRow == 1 || cellRow == 2) {
			squareRowNum = 0;
		} else if(cellRow == 3 || cellRow == 4 || cellRow == 5) {
			squareRowNum = 1;
		} else {
			squareRowNum = 2;
		}
		
		if(cellCol == 0 || cellCol == 1 || cellCol == 2) {
			squareColNum = 0;
		} else if(cellCol == 3 || cellCol == 4 || cellCol == 5) {
			squareColNum = 1;
		} else {
			squareColNum = 2;
		}
		
		if(squareRowNum == 0) {
			startingRowNum = 0;
		} else if (squareRowNum == 1) {
			startingRowNum = 3;
		} else {
			startingRowNum = 6;
		}
		
		if(squareColNum == 0) {
			startingColNum = 0;
		} else if (squareColNum == 1) {
			startingColNum = 3;
		} else {
			startingColNum = 6;
		}
		
		for(int rowLoop = startingRowNum; rowLoop < startingRowNum + 3; rowLoop++) {
			for(int colLoop = startingColNum; colLoop < startingColNum + 3; colLoop++) {
				Cell cellToAdd = getCellFromGrid(colLoop, rowLoop);
				square.add(cellToAdd);
			}
		}
		
		return square;
	}
	
	public void displayGrid() {

		for(Row row : getGridRows()) {
			System.out.println(row.toString());
		}
		System.out.println("----------------------------");
	}
	
	public Cell getCellFromGrid(int coordinateX, int coordinateY) {
		return getGridRows().get(coordinateY).getRow().get(coordinateX);
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
