class Solution {

    /*
    Trick: check zeros, if yes everything else 0.
    left multiple and right multiple and ans is the final sum


    */

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] lProd = new int[nums.length];
        int[] rProd = new int[nums.length];
        lProd[0] = rProd[n-1] = 1;
        
        int hasZeros = 0;

        if(nums[0] == 0 || nums[n-1] == 0)
            hasZeros++;

        for(int i=1; i < nums.length; i++){

            if(nums[i] == 0)
                hasZeros++;

            lProd[i] = nums[i-1]*lProd[i-1];
            rProd[n-i-1] = nums[n-i]*rProd[n-i];
        } 

        int[] ans = new int[n];
        for(int i =0; i < nums.length; i++){
            ans[i] = lProd[i]*rProd[i];
        }

        return ans;
    }
}