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
	
	public void addCell(Cell cell) {
		getRow().add(cell);
	}
	
	public void addCells(List<Cell> cells) {
		getRow().addAll(cells);
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
