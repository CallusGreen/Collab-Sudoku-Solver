package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {

	// Class Variables
	private ArrayList<Cell> rowOfCells;

	// Constructor
	public Row() {
		this.rowOfCells = new ArrayList<>();
	}

	
	// Methods
	public void addCellToRow(Cell cell) {
		this.rowOfCells.add(cell);
	}

	@Override
	public String toString() {

		String rowOfCellValues = "";
		for(Cell cell: this.rowOfCells){
			rowOfCellValues += cell;
		}
		return rowOfCellValues;
	}

	
	// Getters & Setters
	public ArrayList<Cell> getRowOfCells() {
		return this.rowOfCells;
	}
}
