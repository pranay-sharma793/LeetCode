class Solution {
    int[] par;
    int[] rank;
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        par = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            par[i] =i;
            rank[i] = 1;
        }
        List<int[]> edges = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        }

        edges.sort((a,b) -> Integer.compare(a[0], b[0]));
        int res = 0;

        for(int[] edge : edges){
            if(union(edge[1], edge[2])){
                res += edge[0];
            }
        }

        return res;
    }

    private boolean union(int e1, int e2){
        int p1 = find(e1);
        int p2 = find(e2);

        if(p1 == p2) return false;

        if(rank[p1] < rank[p2]){
            par[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }

        return true;
    }

    private int find(int edge){
        int res = edge;

        while(res != par[res]){
            par[res] = par[par[res]];
            res = par[res];
        }

        return res;
    }
}