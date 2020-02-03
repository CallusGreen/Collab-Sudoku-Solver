package logic;

import java.util.ArrayList;

public class SolutionCheck {
    private boolean checkRowOrColContainsSequence(ArrayList<Cell> row){
        Cell cell;
        for(int index=1; index<10; index++){
            cell = new Cell(index);
            if(!row.contains(cell)){
                return false;
            }
        }
        return true;
    }

    public void checkSolution(Grid grid){
        // check the rows
        System.out.println("Checking rows...");
        for(Row r: grid.getGridRows()){
            if(!checkRowOrColContainsSequence(r.getRow())){
                System.out.println("Solution is incorrect!");
                return;
            }
        }

        for(int index=0; index<9; index++){
            if(!checkRowOrColContainsSequence(grid.getColumn(index))){
                System.out.println("Solution is incorrect!");
                return;
            }
        }
        System.out.println("Solution is correct!");
    }
}
