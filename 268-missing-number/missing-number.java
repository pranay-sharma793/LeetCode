class Solution {
    public int missingNumber(int[] nums) {
        
        int sum1 = 0;
        int sum2= 0;
        int n = nums.length;

        for(int i=0; i < n; i++){
            sum1+= nums[i];
            sum2+= i;
        }

        sum2 = sum2 + n;

        return sum2 - sum1;
    }
}