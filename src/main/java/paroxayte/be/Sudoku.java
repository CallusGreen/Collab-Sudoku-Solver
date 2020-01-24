package paroxayte.be;
import java.util.Arrays;
import paroxayte.util.Pair;

public class Sudoku {
  private static final int USZ = 9;
  private static final int[] CORRECT = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

  private enum UnitType { ROW, COL, NON };

  // indicate which unit failed validation
  private Pair<UnitType, Integer> errLoc;

  public int[][] board = new int[9][9];

  public Sudoku(int[][] board) {
    for(int i = 0; i < USZ; i++) {

      for(int j = 0; j < USZ; j++) {
        this.board[i][j] = board[i][j];
      }
    }
  }

  private int[] getRow(int i) {
    return board[i];
  }

  private int[] getCol(int i) {
    int[] ret = new int[USZ];
    for (int n = 0; n < USZ; n++) {
      ret[n] = board[n][i];
    }

    return ret;
  }

  // nonets indexed left to right, top to bottom
  private int[] getNonet(int i) {
    int row = i / 3 * 3;
    int col = i % 3 * 3;

    int bound = 3;// sqrt(USZ)

    int[] ret = new int[USZ];
    for (int n = 0, k = 0; n < bound; n++) {

      for (int j = 0; j < bound; j++) {
        ret[k] = board[n + row][j + col];
        k++;
      }
    }

    return ret;
  }

  // validates an int[9]
  private boolean validateSegment(int[] s) {
    int[] test = new int[USZ];
    System.arraycopy(s, 0, test, 0, USZ);
    Arrays.sort(test);
    return test.length == USZ && Arrays.equals(test, CORRECT);
  }

  public boolean validate() {
    for (int i = 0; i < USZ; i++) {

      if (!validateSegment(getRow(i))) {
        errLoc = new Pair<>(UnitType.ROW, i);
        return false;
      } else if(!validateSegment(getCol(i))) {
        errLoc = new Pair<>(UnitType.COL, i);
        return false;
      }else if(!validateSegment(getNonet(i))) {
        errLoc = new Pair<>(UnitType.NON, i);
        return false;
      }

    }

    return true;
  }

  public Pair<UnitType, Integer> getErr() {
    return errLoc;
  }

}

