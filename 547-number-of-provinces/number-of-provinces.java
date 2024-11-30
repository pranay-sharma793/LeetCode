class Solution {
    int[] par;
    int[] rank;
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected[0].length;
        par = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            par[i]=i;
            rank[i]=1;
        }

        int res = n;

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    res-=union(i,j);
                }
            }
        }

        return res;
    }

    private int union(int e1, int e2){
        int edge1 = find(e1);
        int edge2 = find(e2);

        if(edge1 == edge2) return 0;

        if(rank[edge1] > rank[edge2]){
            par[edge2] = edge1;
            rank[edge1] += rank[edge2];
        } else {
            par[edge1] = edge2;
            rank[edge2] += rank[edge1];
        }

        return 1;
    }

    private int find(int node){

        int res = node;

        while(res != par[res]){
            par[res] = par[par[res]];
            res = par[res];
        }

        return res;
    }
}