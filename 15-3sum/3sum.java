class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int target = nums[i];

            int s = i+1;
            int e = n-1;

            while(s < e){
                if(target + nums[s] + nums[e] == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(target);
                    tmp.add(nums[s]);
                    tmp.add(nums[e]);

                    ans.add(tmp);
                    
                    while (s < e && nums[s] == nums[s + 1]) {
                        s++;
                        }
                    while (s < e && nums[e] == nums[e - 1]) {
                        e--;
                        }
                }
                else if(target + nums[s] + nums[e] > 0){
                    e--;
                    continue;
                }
                else {
                    s++;
                    continue;
                }

                s++;
                e--;
            }
            
        }

        return ans;
        
    }
}