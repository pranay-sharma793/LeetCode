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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;

        // This returns the max positive value left subtree can provide
        int left = Math.max(0, helper(root.left));

        //This return the max positive value the right subtree can provide
        int right = Math.max(0, helper(root.right));

        //This sets maxsum if the root, left and right itself have a bigger sum
        maxSum = Math.max(maxSum, left + right + root.val);

        //here we return the value root + the biggest subtree value either on its left or right.
        return Math.max(left, right) + root.val;


    }
}