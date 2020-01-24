package logic;

public class Cell {

	private int value;
	private int xCoordinate;
	private int yCoordinate;
	
	// Constructor
	public Cell(int value, int xCoordinate, int yCoordinate) {
		this.setValue(value);
		this.setXCoordinate(xCoordinate);
		this.setYCoordinate(yCoordinate);
	}
	
	// getters
	public int getValue() {
		return value;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	

	// setters
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
