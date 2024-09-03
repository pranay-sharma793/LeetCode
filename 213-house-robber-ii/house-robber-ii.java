/**
Sine the houses are in circle, its either second to last house OR first to second last house.

Time: O(n)
Space: O(1)
 */

class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        return Math.max(helperRob(nums,0,nums.length-1), helperRob(nums, 1, nums.length));
    }

    private int helperRob(int[] nums, int start, int end){
        int prev = 0;
        int curr = 0;

        for(int i=start; i<end; i++){
            int tmp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = tmp;
        }

        return curr;
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