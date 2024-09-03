class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        int prev = 0;
        int curr = 0;

        for(int i=0; i<nums.length-1; i++){
            int tmp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = tmp;
        }
        
        int sum1 = curr;

        prev = 0;
        curr = 0;

        for(int i=1; i<nums.length; i++){
            int tmp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = tmp;
        }

        return Math.max(sum1, curr);
    }


    // public int rob(int[] nums) {

    //     int dp[] = new int[nums.length+1];


    //     int prev = nums[nums.length-1];
    //     int curr = nums[0];

    //     for(int i = 1; i < nums.length; i++){
    //         dp[i+1] = Math.max(nums[i], nums[i-1]+prev);
    //     }

    //     return dp[nums.length];
    // }
}