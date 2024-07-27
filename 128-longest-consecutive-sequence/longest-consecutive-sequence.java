class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int ans=0;

        for(int n: nums)
            set.add(n);

        for(int n: nums){

            int count=1;

            if(set.contains(n-1)){
                continue;
            }
            else{
                while(set.contains(n + 1)){
                    count++;
                    n++;
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
        
    }
}