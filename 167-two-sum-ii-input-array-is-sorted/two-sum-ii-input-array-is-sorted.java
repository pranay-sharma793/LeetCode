class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];
 
        for(int i = 0; i < numbers.length; i++){
            int tmp = numbers[i];
            ans[0] = i+1;
            int n = i+1;
            while(n < numbers.length){
                if(numbers[n] + tmp == target){
                    ans[1] = n+1;
                    return ans;
                }
                n++;
            }

        }

        return ans;
        
    }
}