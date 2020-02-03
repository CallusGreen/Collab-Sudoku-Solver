package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Row implements Serializable {

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
		this.row.add(cell);
	}
	
	public void addMultipleCellsToRow(List<Cell> cells) {
		this.row.addAll(cells);
	}

	@Override
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
		return this.row;
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
