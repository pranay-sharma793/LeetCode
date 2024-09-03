class Solution {
    public int rob(int[] nums) {
        int curr = 0;
        int prev = 0;

        for(int i=0; i < nums.length; i++){
            int tmp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = tmp;
        }

        return curr;
        
    }
}