class Solution {
    int[] par;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        par = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            par[i]=i;
            rank[i]=1;
        }

        for(int[] edge : edges){
            if(!union(edge)) return new int[] {edge[0], edge[1]};
        }

        return new int[2];

    }

    private boolean union(int[] edge){

        int par_e1 = find(edge[0]-1);
        int par_e2 = find(edge[1]-1);

        if(par_e1 == par_e2) return false;

        if(rank[par_e1] > rank[par_e2]){
            par[par_e2] = par_e1;
            rank[par_e1] += rank[par_e2];
        } else {
            par[par_e1] = par_e2;
            rank[par_e2] += rank[par_e1];
        }

        return true;
    }

    private int find(int edge){
        int res=edge;

        while(res != par[res]){
            par[res] = par[par[res]];
            res = par[res];
        }

        return res;
    }
}