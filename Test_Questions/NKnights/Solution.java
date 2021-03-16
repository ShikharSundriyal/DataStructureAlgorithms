import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
      
        printNKnights(chess, "", 0,0,n);

    }
    public static boolean canPlaceKnight(int[][] chess, int row, int col) {
        //row,n
       if(chess[row][col] == 1)
            return false;
       
        if(row-2 >= 0 && col+1 <chess[0].length && chess[row-2][col+1]== 1) 
            return false; 
        if(row-1>=0 && col+2 <chess[0].length && chess[row-1][col+2]== 1) 
            return false;
        if(row+1 < chess.length && col+2<chess[0].length && chess[row+1][col+2]== 1) 
            return false;
        if(row+2< chess.length && col+1< chess[0].length && chess[row+2][col+1]== 1) 
            return false;
        if(row+2 < chess.length && col-1>= 0 && chess[row+2][col-1]== 1) 
            return false;
        if(row+1 < chess.length && col-2>=0 && chess[row+1][col-2]== 1) 
            return false;
        if(row-1 >= 0 && col-2 >=0 && chess[row-1][col-2]== 1) 
            return false;
        if(row-2>=0 && col-1 >=0 && chess[row-2][col-1]== 1) 
            return false;
        //for(int i= row ;i>=0;i--){}
     
        return true;
    }
  public static void printNKnights(int[][] chess, String qsf, int row, int col, int knights) {
        
       
        if (knights == 0) {
            System.out.println(qsf + ".");
            return;
        }
      for(int i =row;i<chess.length;i++){
          for(int j=col;j<chess.length;j++){
           if (canPlaceKnight(chess,i, j) == true) {
                //System.out.println(row+" -> "+col);
                chess[i][j] = 1;
                printNKnights(chess,qsf+i+"-"+j+ ", ",i,j, knights-1);
                chess[i][j] = 0;
                }   
          }
          // this is imp otherwise you will miss some results, as after moving to
          //next row you have option to be placed at any column
          col = 0;
      }
      

    }
}