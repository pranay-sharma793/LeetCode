class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int[] res = new int[queries.length];
        int i =0;

        for(int[] query : queries){
            int left = query[0];
            int right = query[1];

            for(int j=left; j <= right; j++){
                res[i] ^= arr[j];
            }
            i++;

        }
        

        return res;
    }
}