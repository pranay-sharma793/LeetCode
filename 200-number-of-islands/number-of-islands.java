class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;

        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                    islands++;
                    updateGrid(grid, i , j);
                }
            }
        }

        return islands;
        
    }

    public void updateGrid(char[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1' ) return;

        grid[i][j] = 'X';

        updateGrid(grid, i+1, j);
        updateGrid(grid, i, j+1);
        updateGrid(grid, i-1, j);
        updateGrid(grid, i, j-1);
    }
}