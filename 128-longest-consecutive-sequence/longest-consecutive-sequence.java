/*
Trick to conver the num array to a set so that we can easily check.

We here check if it a start of the sequence by checking n-1 and loop over performing n+1 until we do not have the next value. We then store the max value all the sequences. 

Update: checking if have found a sequence more than half the length of the array. This basically menas we have the longest possible sequence. Here we break and return value.


Learning: checking maxLen greater than half, putting array in a set. 
 */


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


            if(ans > nums.length/2) break;
        }

        return ans;
        
    }
}