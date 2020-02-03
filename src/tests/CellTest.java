package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Cell;

class CellTest {

	@Test
	void testToStringWithValue() {
		Cell cell = new Cell(5, 0, 0);
		
		String expectedOutput = " 5 ";
		String actualOutput = cell.toString();

		assertTrue(expectedOutput.equals(actualOutput));
	}
	
	@Test
	void testToStringWithoutValue() {
		Cell cell = new Cell(0, 0, 0);
		
		String expectedOutput = " . ";
		String actualOutput = cell.toString();
		
		boolean outputsAreTheSame = expectedOutput == actualOutput;

		assertTrue(outputsAreTheSame);
	}

}
