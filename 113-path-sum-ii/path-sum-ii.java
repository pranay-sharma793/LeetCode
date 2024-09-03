/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        helper(root, targetSum, 0);

        return result;
    }

    private void helper(TreeNode root, int target, int curr_sum){
        if(root == null) return;
        
        res.add(root.val);
        curr_sum += root.val;

        if(root.left == null && root.right == null){
            if(curr_sum == target){
                result.add(new ArrayList<>(res));
                // return;
            } 
        } 

        helper(root.left, target, curr_sum);
        helper(root.right, target, curr_sum);

        int s = res.size();
        res.remove(s-1);
    }
}