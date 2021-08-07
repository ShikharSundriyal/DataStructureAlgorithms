You have N * N matrix , you have to place N queen in the matrix. Which means at each matrix location we can place a queen which is similar to subsets approach as each selecting 
each matric location has 2 choices either it will be selected or it cannot be selected.

From both the recursive calls we will always move towards right of the matrix till we reach the end of the row and once we reach the end of row we have to select next box from next row.<br/>

pseudo code :<br/>

void nqueenvar(int row, int col, string psf, int N) <br/>

// to adjust moving to next row<br/>
if(col == N){<br/>
  row = row+1;<br/>
  col = 0;<br/>
}<br/>
//selected<br/>
nqueensvar(row,col+1,psf+row+col)<br/>
// box not selected<br/>
nqueensvar(row,col+1,psf)<br/>
