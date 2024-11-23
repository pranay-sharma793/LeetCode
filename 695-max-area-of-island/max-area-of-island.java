class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max_area = 0;

        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1){
                    int area = getArea(grid, i, j);
                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }

    private int getArea(int[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;

        grid[i][j] = -1;

        int area = 1;

        area += getArea(grid, i+1, j);
        area += getArea(grid, i-1, j);
        area += getArea(grid, i, j+1);
        area += getArea(grid, i, j-1);

        return area;
    }
}