class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for(int i =0;i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] != '.'){
                    int box_number = (i/3)*3 + j/3; 
                    int row = i;
                    int col = j;
                    String enc = board[i][j]+"box-"+box_number;
                    String enc1 = board[i][j]+"row-"+i;
                    String enc2 = board[i][j]+"col-"+j;
                    
                    if(hs.contains(enc)||hs.contains(enc1)||hs.contains(enc2)) {
                        
                        return false;
                    }
                    else {hs.add(enc);hs.add(enc1);hs.add(enc2);}
                }
            }
        }
        return true;
    }
}
