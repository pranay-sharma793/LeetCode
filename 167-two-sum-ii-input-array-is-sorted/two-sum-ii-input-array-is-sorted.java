/**
trick: since the array is sorted we take two end pointer and keep checking for sum. 
if sum is greater than move right pointer to smaller number else move left pointer to higher nums

learning: return new int[] {val, val}
 */


class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length -1;
        
        while(l < r){
            if(numbers[r] + numbers[l] == target)
                return new int[] {l+1 , r+1};
            else if(numbers[r] + numbers[l] > target)
                r--;
            else
                l++;
        }

        return new int[2];
        
    }
}