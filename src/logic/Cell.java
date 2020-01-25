package logic;

public class Cell {

	// Variables 
	private int value;
	private int xCoordinate;
	private int yCoordinate;
	
	
	// Constructors
	public Cell(int value, int xCoordinate, int yCoordinate) {
		this.setValue(value);
		this.setXCoordinate(xCoordinate);
		this.setYCoordinate(yCoordinate);
	}

	public Cell(){
	    this(0,0,0);
	  }
	
	
	// Methods
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
}
