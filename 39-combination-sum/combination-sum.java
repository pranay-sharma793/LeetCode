/**
we wish to find unique combinations without getting duplicates. 
So here we approach it in such a way that we take one element and create two ways of either again using the same value, 
or not using the same value at all.
                            [2]
                            /\
                     /               \
recursive call with 2 (idx)          recursive call without 2 (idx+1)


	•	Time complexity: O(2^n \cdot k), where n is the number of candidates and k is the average length of the combination.
	•	Space complexity: O(C \cdot k + \frac{target}{min(candidates)}), where C is the number of valid combinations and k is the average length of the combination.

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, curr, 0);
        return ans;
        
    }

    private void backtrack(
        int[] candidates,
        int target,
        List<Integer> curr,
        int idx
    ){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        } else if(target < 0 || idx >= candidates.length) return;
        else {

            curr.add(candidates[idx]);
            backtrack(candidates, target - candidates[idx], curr, idx);

            curr.remove(curr.get(curr.size() -1));
            backtrack(candidates, target, curr, idx+1);

        }

    }
}