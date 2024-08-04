/**
Trick: Since all numbers are in starting with 0 until n. Sum all the nums and sum the total length values. The missing value is the diff
 */

class Solution {
    public int missingNumber(int[] nums) {
        
        int sum1 = 0;
        int sum2= 0;
        int n = nums.length;

        sum2 = (n*(n+1))/2;

        for(int i=0; i < n; i++){
            sum1+= nums[i];
            // sum2+= i;
        }

        // sum2 = sum2 + n;

        return sum2 - sum1;
    }
}