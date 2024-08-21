/**
Binary search question:: check if first is less than last elements then its sorted, then apply normal BS.
Else find the start or min element and compare with the either 0 or nth and apply BS on one side of the min element.

remember: nums[n-1] < target,  int mid = start + (end - start)/2;,  int prev = (mid + n - 1) % n;, int next = (mid + 1) % n;
 */

class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int n = nums.length;
        int end = n-1;

        int ans = -1;

        if(n == 1){
            if(nums[0] == target) return 0;
            else return -1;
        }

        if(nums[0] < nums[end]){
            ans = perBS(nums, 0, n - 1,target);
            return ans;
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if(nums[mid] < nums[prev] && nums[mid] < nums[next]){
                int tmp = nums[mid];
                if(tmp == target) return mid;

                if(nums[n-1] < target) ans = perBS(nums, 0, mid - 1,target);
                else ans = perBS(nums, mid + 1, n-1,target);
                break;

            } else if(nums[0] <= nums[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return ans;
        
    }

    public int perBS(int[] nums, int s, int e, int target){
        int start = s;
        int end = e;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid -1;
            else start = mid + 1;
        }

        return -1;
    }
}