package gui;

import model.Cell;
import model.Grid;
import model.Row;

public class ConsoleDisplay {

    // Methods to set Game messages
    public static String userPromptAsString(){
        return "Game input must be 3 values in the form of: (x-coordinate, y-coordinate, value) \nEnter -1 to quit \n Enter your move: ";
    }

    public static String endGamePromptString(){
        return "Game has ended!";
    }

    public static String wrongInputString(){
        return "Error! Please enter move according to this format: (x-coordinate, y-coordinate, value) \nEnter -1 to quit \n Enter your move: ";
    }


    // Methods to calculate game board display
    private static String cellAsString(Cell cell){
        return (cell.getValue() == 0) ? " . " : " " + cell.getValue() + " ";
    }

    private static String rowAsString(Row row){
        String rowString = "";
        for(int index=0; index<row.getRowOfCells().size(); index++){
            Cell cell = row.getRowOfCells().get(index);
            rowString += (index != 0 && index % 3 == 0) ? (cellAsString(cell) + " ") : (cellAsString(cell));
        }
        return rowString;
    }

    private static String gridAsString(Grid grid){
        String gridString = "";
        for(Row row: grid.getGrid()){
            gridString += rowAsString(row) + "\n";
        }
        return gridString;
    }

    // Method to display Game
    public static void displayGame(Grid grid){
        System.out.println(gridAsString(grid));
    }
}
