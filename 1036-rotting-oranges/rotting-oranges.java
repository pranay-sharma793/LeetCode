class Solution {
    public int orangesRotting(int[][] grid) {

        int freshOrgs = 0;
        Queue<int[]> queue = new LinkedList<>();

        int[][] dist = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        for(int r=0; r < grid.length; r++){
            for(int c=0; c < grid[0].length; c++){

                if(grid[r][c] == 2){
                    queue.add(new int[] {r,c});
                }
                if(grid[r][c] == 1){
                    freshOrgs++;
                }
            }
        }

        if(freshOrgs == 0) return 0;

        int time = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            time++;

            for(int k=0; k < size; k++){

                int[] pos = queue.poll();

                for(int[] dir: dist){
                    int new_r = pos[0] + dir[0];
                    int new_c = pos[1] + dir[1];
              
                    if(rottenOrange(grid, new_r, new_c)){
                        freshOrgs--;
                        queue.add(new int[] {new_r, new_c});
                    }
                
                }
                if(freshOrgs == 0) return time;

            }
        }

        return freshOrgs==0?time:-1;
        
    }

    private boolean rottenOrange(int[][] grid, int r, int c){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) return false;

        if(grid[r][c] == 1){
            grid[r][c] = 2;
            return true;
        }

        return false;
    }
}