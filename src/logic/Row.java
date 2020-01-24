package logic;

import java.util.ArrayList;
import java.util.List;

public class Row {

	// Class Variables
	private ArrayList<Cell> row;
	private int rowNumber;
	
	
	// Constructors
	public Row() {
		this.row = new ArrayList<>();
	}
	
	public Row(int rowNumber) {
		this.row = new ArrayList<>();
		this.rowNumber = rowNumber;
	}

	
	// Methods
	public void addCellToRow(Cell cell) {
		getRow().add(cell);
	}
	
	public void addMultipleCellsToRow(List<Cell> cells) {
		getRow().addAll(cells);
	}
	
	public String toString() {
		String output = "";
		
		for(Cell cell : getRow()) {
			output = output + cell;
		}
		
		if(getRowNumber() != 0 && (getRowNumber() + 1) % 3 == 0) {
			output = output + "\n";
		}
		
		return output;
	}

	
	// Getters & Setters
	public ArrayList<Cell> getRow() {
		return row;
	}

	public void setRow(ArrayList<Cell> row) {
		this.row = row;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
}
