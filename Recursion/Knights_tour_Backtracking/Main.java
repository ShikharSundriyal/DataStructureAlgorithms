import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        int row = sc.nextInt();
        int col = sc.nextInt();
        printKnightsTour(chess,row,col,1);

    }

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {
        
		// handle out of board calls and check if the position is unvisited which means
		// is does not have any move applied on it (arr[i][j] > 0)
		if(row <0 || col <0 || row >= chess.length || col >= chess.length || chess[row][col] > 0){
            return;
        }
		//base case , all 24 moves have been placed and for the 25 th move first you
		//place the move in arr[row][col] , print it and undo the move to check for other answers.
		// if you needed only one configuration just dont undo the 25th move 
        if(move == chess.length * chess.length){
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        printKnightsTour(chess, row-2,col+1 ,move+1);
        printKnightsTour(chess, row-1,col+2 ,move+1);
        printKnightsTour(chess, row+1,col+2 ,move+1);
        printKnightsTour(chess, row+2,col+1 ,move+1);
        printKnightsTour(chess, row+2,col-1 ,move+1);
        printKnightsTour(chess, row+1,col-2 ,move+1);
        printKnightsTour(chess, row-1,col-2 ,move+1);
        printKnightsTour(chess, row-2,col-1 ,move+1);
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}