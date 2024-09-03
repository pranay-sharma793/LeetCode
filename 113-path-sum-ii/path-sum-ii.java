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

        helper(root, targetSum);

        return result;
    }

    private void helper(TreeNode root, int target){
        if(root == null) return;
        
        res.add(root.val);
        // curr_sum += root.val;

        if(root.left == null && root.right == null && target == root.val){
                result.add(new ArrayList<>(res));
        } 

        // helper(root.left, target, curr_sum);
        // helper(root.right, target, curr_sum);

        helper(root.left, target - root.val);
        helper(root.right, target - root.val);

        int s = res.size();
        res.remove(s-1);
    }
}