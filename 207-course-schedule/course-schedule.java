class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] possible = new boolean[numCourses];

        for(int i=0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] preReq: prerequisites){
            adj.get(preReq[0]).add(preReq[1]);
        }

        for(int i=0; i < numCourses; i++)
        {
            if(!possible[i] && !dfs(i, new HashSet<>(), possible)) return false;
        }

        return true;
    }

    private boolean dfs(int node,Set<Integer> visited, boolean[] possible){

        if(possible[node]) return true;
        if(visited.contains(node)) return false;
        
        visited.add(node);
        List<Integer> courses = adj.get(node);

        for(Integer course : courses){
            if(!dfs(course, visited, possible)) return false;
        }

        possible[node] = true;
        return true;
    }
}