class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] != '0'){
                    recurse(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void recurse(int sr, int sc, char[][] maze){
        if(sr<0 || sc <0 || sc>= maze[0].length || sr>= maze.length || maze[sr][sc] =='0') return;
        
        maze[sr][sc] = '0';
        recurse(sr-1,sc,maze);
        recurse( sr,sc-1,maze);
        recurse( sr+1,sc,maze);
        recurse(sr,sc+1,maze);
    }
}
