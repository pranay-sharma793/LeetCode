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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;

        if(subRoot == null) return true;

        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //checking if the structure is same
        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;

        // checking if the value are the same
        if(p.val != q.val) return false;

        // call recursively to the right and left
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}