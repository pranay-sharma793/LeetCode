/**
binary search to find the min value. Move to the unsorted array size. compare first and last element to the mid to decide. 
Learning: mid calculation is start + (end - start)/2 to prevent int overflow. 

prev and next is calculated with % n to avoid index out of bound and to rotate back.
 */


class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int start = 0;
        int end = n-1;

        if(nums[start] < nums[end]) return nums[start];

        while(start <= end){
            int mid = start + (end - start) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){
                return nums[mid];
            } else if(nums[0] <= nums[mid]) {
                start = mid + 1;
                // end = mid - 1;
            } else if(nums[mid] <= nums[n-1]){
                end = mid - 1;
                // start = mid + 1;
            }
        }

        return -1;
    }
}