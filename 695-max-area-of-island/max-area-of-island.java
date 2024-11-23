class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m_area = 0;

        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){

                if(grid[i][j] == 1){
                    int area = getArea(grid, i ,j);
                    m_area = Math.max(m_area, area);
                }
            }
        }

        return m_area;
    }

    private int getArea(int[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;

        grid[i][j] = -1;

        int area = 1;

        area += getArea(grid, i+1, j);
        area+= getArea(grid, i-1, j);
        area += getArea(grid, i, j+1);
        area += getArea(grid, i, j-1);

        return area;

        // if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;



        // return 1 + getArea(grid, i+1, j) + getArea(grid, i-1, j) + getArea(grid, i, j+1) + getArea(grid, i, j-1);
    }
}