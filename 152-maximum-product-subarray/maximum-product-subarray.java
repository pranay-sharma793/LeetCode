/**

Since nums also contain negaitve values. We have to optimise our approach.
Here what we do is that take products of numbers from both the ends.
At each stage we store the max prod.
When we encounter a 0, we reset the pre and suff to 1.

	•	Time Complexity: O(n)
	•	Space Complexity: O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {

        int prefix = 1;
        int suffix = 1;

        int maxProd = nums[0];

        for(int i = 0; i < nums.length; i++){

            int preVal = nums[i];
            int sufVal =nums[nums.length - i -1];

            prefix = prefix*preVal;
            suffix = suffix*sufVal;

            maxProd = Math.max(maxProd, Math.max(prefix, suffix));

            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

        }

        return maxProd;
        
    }
}