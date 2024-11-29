class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    int k=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] possible = new boolean[numCourses];
        int[] ans = new int[numCourses];

        for(int i=0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] preReq: prerequisites){
            adj.get(preReq[0]).add(preReq[1]);
        }

        for(int i=0; i < numCourses; i++)
        {
            if(!possible[i] && !dfs(i, new HashSet<>(), possible, ans)) return new int[0];
        }

        return ans;
    }

    private boolean dfs(int node,Set<Integer> visited, boolean[] possible, int[] ans){

        if(possible[node]) return true;
        if(visited.contains(node)) return false;
        
        visited.add(node);
        List<Integer> courses = adj.get(node);

        for(Integer course : courses){
            if(!dfs(course, visited, possible, ans)) return false;
        }

        possible[node] = true;
        ans[k++] = node;
        return true;
    }
}