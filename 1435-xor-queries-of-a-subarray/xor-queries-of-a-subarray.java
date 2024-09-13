class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        //using prefix XOR array
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for(int i =1; i < arr.length; i++){
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        int[] res = new int[queries.length];
        int i =0;

        for(int[] query : queries){
            int left = query[0];
            int right = query[1];

            if(left == 0) res[i] = prefix[right];
            else res[i] = prefix[right] ^ prefix[left -1];

            // for(int j=left; j <= right; j++){
            //     res[i] ^= arr[j];
            // }
            i++;

        }
        

        return res;
    }
}