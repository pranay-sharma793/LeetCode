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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return helper(root, targetSum, 0);
        
    }

    private boolean helper(TreeNode root, int target, int curr_sum){
        if(root == null) return false;

        curr_sum += root.val;

        if(root.left == null && root.right == null){
            return curr_sum == target;
        }

        return helper(root.left, target, curr_sum) || helper(root.right, target, curr_sum);
    }
}