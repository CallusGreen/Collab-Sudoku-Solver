package model;

import java.io.Serializable;

public class Cell implements Serializable {

	// Variables 
	private int value;
	private int xCoordinate;
	private int yCoordinate;
	
	
	// Constructors
	public Cell(int value, int xCoordinate, int yCoordinate) {
		this.value = value;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public Cell(int xCoordinate, int yCoordinate) {
		this(0, xCoordinate, yCoordinate);
	}

	public Cell(int value){
		this(value, 0,0);
	}

	public Cell(){
		this(0,0,0);
	}



	// Getters & Setters

	public int getValue() {
		return value;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}
	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	// Methods
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}

		if(getClass() != object.getClass()) {
			return false;
		}

		Cell compared = (Cell) object;

		if(this.getValue() != compared.getValue()){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String output = "";

		if(getValue() == 0) {
			output =  " . ";

		} else {
			output = " " + getValue() + " ";
		}

		if(getXCoordinate() != 0 && (getXCoordinate() + 1) % 3 == 0) {
			output = output + " ";
		}

		return output;
	}

	public String toCoordinates() {
		return "(" + getXCoordinate() + "," + getYCoordinate() + ")";
	}
}
