/**
Working solution but with out BFS.
Have to retry this problem with queue and BFS approach. Keeping adding each updated 1 to 2 in the queue while queue is not empty. Keep a track of the initial 1s in the 0th run. If 1s > 0 after all return -1 else return min.
BFS time will be O(m * n)


Current soln time: O((n * m) * k) //where k is minutes
Space: O(n * m) /worst case for list
 */
class Solution {
    public int orangesRotting(int[][] grid) {

        int min = 0;
        List<int[]> rotPos = new ArrayList<>();

        rotPos = findRottenOrange(grid);

        while(rotPos.size() > 0 && updateNextMinute(rotPos, grid)){
            rotPos = findRottenOrange(grid);
            min++;
        }

        if(stillFresh(grid)) return -1;

        return min;
    }

    private List<int[]> findRottenOrange(int[][] grid){

        int[] pos;
        List<int[]> result= new ArrayList<>();

        for(int i=0; i<grid.length;i++){
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    pos = new int[2];
                    pos[0]=i;
                    pos[1]=j;
                    result.add(pos);
            }
        }
      }

      return result;

    }

    private boolean updateNextMinute(List<int[]> rotPos, int[][] grid){
        boolean didUpdate = false;

        for(int k=0; k < rotPos.size(); k++){
            int[] pos = rotPos.get(k);
            int i = pos[0];
            int j = pos[1];

            grid[i][j] = -1;
            
            if(i+1 >= 0 && i+1 < grid.length){
                if(grid[i+1][j]==1){
                    grid[i+1][j] = 2;
                    didUpdate = true;
                }
            }

            if(i-1 >= 0 && i-1 < grid.length){
                if(grid[i-1][j]==1){
                    grid[i-1][j] = 2;
                    didUpdate = true;
                }
            }

            if(j+1 >= 0 && j+1 < grid[i].length){
                if(grid[i][j+1]==1){
                    grid[i][j+1] = 2;
                    didUpdate = true;
                }
            }

            if(j-1 >= 0 && j-1 < grid[i].length){
                if(grid[i][j-1]==1){
                    grid[i][j-1] = 2;
                    didUpdate = true;
                }
            }
            
        }

        return didUpdate;
    }

    private boolean stillFresh(int[][] grid){


        for(int i=0; i<grid.length;i++){
        for(int j =0; j < grid[i].length; j++){
            if(grid[i][j] == 1){
                return true;
            }
        }
      }

      return false;
      
    }

}