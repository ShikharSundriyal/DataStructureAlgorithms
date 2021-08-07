You have N * N matrix , you have to place N queen in the matrix. Which means at each matrix location we can place a queen which is similar to subsets approach as each selecting 
each matric location has 2 choices either it will be selected or it cannot be selected.

From both the recursive calls we will always move towards right of the matrix till we reach the end of the row and once we reach the end of row we have to select next box from next row.

pseudo code :

void nqueenvar(int row, int col, string psf, int N)

// to adjust moving to next row
if(col == N){
  row = row+1;
  col = 0;
}
//selected
nqueensvar(row,col+1,psf+row+col)
// box not selected
nqueensvar(row,col+1,psf)
