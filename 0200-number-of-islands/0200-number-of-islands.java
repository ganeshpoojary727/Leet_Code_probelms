class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int[][] visited,int i,int j){
        if( i<0||i>=grid.length ||
            j<0||j>=grid[0].length||
            grid[i][j]!='1'||
            visited[i][j]==1){
                return;
            }
            visited[i][j]=1;
            dfs(grid,visited,i+1,j);
            dfs(grid,visited,i-1,j);
            dfs(grid,visited,i,j+1);
            dfs(grid,visited,i,j-1);
    }
}