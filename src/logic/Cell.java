package logic;

public class Cell {

	private int value;
	private int x_coord;
	private int y_coord;
	
	public Cell(int value, int x_coord, int y_coord) {
		this.setValue(value);
		this.setX_coord(x_coord);
		this.setY_coord(y_coord);
	}

	public int getY_coord() {
		return y_coord;
	}

	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}

	public int getX_coord() {
		return x_coord;
	}

	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
