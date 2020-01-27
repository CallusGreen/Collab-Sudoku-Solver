package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Cell;
import logic.Row;

class RowTest {

	@Test
	void test() {

		Row row = new Row();
		
		for(int i = 0; i < 9; i++) {
			Cell cell = new Cell(i+1, i, 0);
			row.addCellToRow(cell);
		}
		
		String expected = " 1  2  3   4  5  6   7  8  9  \r\n";
		String actual = row.toString();
		
		System.out.println(actual);
		//change
		assertTrue(expected == actual);
	}

}
