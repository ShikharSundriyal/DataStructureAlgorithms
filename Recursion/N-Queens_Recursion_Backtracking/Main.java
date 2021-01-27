import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);

    }
    public static boolean canPlaceQueen(int[][] chess, int row, int col) {
        //row
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 1) {
                return false;
            }
        }
        // diagnol
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        // diagnol
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;

    }
    public static void printNQueens(int[][] chess, String qsf, int row) {

        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        for (int col = 0; col < chess.length; col++) {

            if (canPlaceQueen(chess, row, col) == true) {
                //System.out.println(row+" -> "+col);
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }

    }
}