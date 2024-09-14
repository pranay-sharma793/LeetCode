class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxNum = nums[0];

        for(int i=1; i<n;i++){
            maxNum = Math.max(maxNum, nums[i]);
            // maxNum = maxNum>nums[i]?maxNum:nums[i];
        }

        int res = 0;
        int maxSub = 0;

        for(int num : nums){
            if(num == maxNum){
                res++;
            } else {
                res = 0;
            }

            maxSub = Math.max(maxSub, res);
        }
        
        return maxSub;
    }
}