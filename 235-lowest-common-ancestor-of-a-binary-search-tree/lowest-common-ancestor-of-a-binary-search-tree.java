/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode LCA = root;
        int val = root.val;

        if((val > p.val) && isCommonAncestor(root.left, p, q)){
            LCA = lowestCommonAncestor(root.left, p, q);
        } else if(isCommonAncestor(root.right, p, q)){
            LCA = lowestCommonAncestor(root.right, p, q);
        }

        return LCA;
    }

    public boolean isCommonAncestor(TreeNode root,  TreeNode p, TreeNode q){

        return (foundNode(root, p) && foundNode(root, q));
    }

    public boolean foundNode(TreeNode root, TreeNode p){

        if(root == null) return false;

        if(root.val == p.val) return true;
 
        return foundNode(root.left, p) || foundNode(root.right, p);
    }
}