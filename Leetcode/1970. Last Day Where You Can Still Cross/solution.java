class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0, r = cells.length-1;
        int[][] dp = new int[row][col];
        int mid=0;
        int lastday = 0;
        while(l <= r){
            mid = (l + r) /2;
            filldp(mid,dp,cells);
            boolean res = isPathPossible(dp);
            if(res == true){
                l = mid + 1;
                lastday = mid;
            }else{
                r = mid -1;
            }
            
            dp = new int[row][col];
        }
        return lastday+1;
        
    }
    
    public void filldp(int n, int[][] dp, int[][] cells){
        for(int i = 0; i <= n; i++){
            int x_row = cells[i][0] - 1;
            int y_row = cells[i][1] - 1;
            dp[x_row][y_row]=1;
        }
    }
    public boolean isPathPossible(int[][] dp  ){
        for( int firstrow = 0 ; firstrow < dp[0].length; firstrow++){
                if(isPathPossibleHelper(0,firstrow,dp.length-1,dp)){
                    return true;
                }
        }
        return false;
    }
    public boolean isPathPossibleHelper(int sr, int sc, int dr,int[][] grid){
        if( sr<0 || sc<0 || sr>=grid.length ||sc>=grid[0].length || grid[sr][sc] == 1) {
            return false;
        }
        if( sr == grid.length-1){
            return true;
        }
        
        grid[sr][sc] = 1;
        // up
        if (isPathPossibleHelper(sr-1,sc,dr,grid)){
            return true;
        }
        //down
        if(isPathPossibleHelper(sr+1,sc,dr,grid)){
            return true;
        }
        //left
        if(isPathPossibleHelper(sr,sc-1,dr,grid)){
            return true;
        }
        //right
        if(isPathPossibleHelper(sr,sc+1,dr,grid)){
            return true;
        }
        return false;
    }
    
}
