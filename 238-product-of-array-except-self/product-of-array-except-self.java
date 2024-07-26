class Solution {

    /*
    Trick: check zeros, if yes everything else 0.
    left multiple and right multiple and ans is the final product of both the two arrays.

    New approach: Not using the pre post arrays, we save the pre in ans and traverese backwards and keep a value 'post' storing the post product and multiplying it to the ans array.
    Pre is first stored in ans, post is set to 1, updated with product of post and next value.

    Learning: Product of array, traversal of array, returned array does not count in the space complexity.


    */

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        // int[] lProd = new int[nums.length];
        // int[] rProd = new int[nums.length];
        // lProd[0] = rProd[n-1] = 1;

        int[] ans = new int[n];
        int post = ans[0] = 1;


        for(int i=1; i < n; i++){
            ans[i] = nums[i-1]*ans[i-1];
        }

        for(int i=n-2; i >= 0; i--){
            post = post*nums[i+1];
            ans[i] = post*ans[i];
        }

        
        // int hasZeros = 0;

        // if(nums[0] == 0 || nums[n-1] == 0)
        //     hasZeros++;

        // for(int i=1; i < nums.length; i++){

        //     if(nums[i] == 0)
        //         hasZeros++;

        //     lProd[i] = nums[i-1]*lProd[i-1];
        //     rProd[n-i-1] = nums[n-i]*rProd[n-i];
        // } 

        // for(int i =0; i < nums.length; i++){
        //     ans[i] = lProd[i]*rProd[i];
        // }

        return ans;
    }
}