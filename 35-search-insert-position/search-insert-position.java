/**

Trick: mid == target then return target else keep going and return end + 1.
Since the array has distinct values.

 */

class Solution {
    // public int searchInsert(int[] nums, int target) {

    //     int start = 0;
    //     int end = nums.length - 1;
    //     int n = nums.length;
    //     int canPut = 0;

    //     while(start <= end){

    //         int mid = start + (end - start)/2;

    //         if(nums[mid] < target){
    //             canPut = mid+1;
    //             start = mid + 1;
    //         } else end = mid - 1;
    //     }

    //     return canPut;
        
    // }
    
        public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid])
                end = mid - 1;
            else start = mid + 1;
        }

        return end + 1;
        
    }
}