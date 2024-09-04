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