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

        if(root == null) return null;

        TreeNode LCA = root;

        if(root.left != null && isCommonAncestor(root.left, p, q)){
            LCA = lowestCommonAncestor(root.left, p, q);
        }

        if(root.right != null && isCommonAncestor(root.right, p, q)){
            LCA = lowestCommonAncestor(root.right, p, q);
        }

        return LCA;


        // if(isCommonAncestor(root, p, q)) return root;

        // if(root.left != null) {
        //     TreeNode LCA = lowestCommonAncestor(root.left, p, q);
        //     if(LCA != null) return LCA;
        // }

        // if(root.right != null) {
        //     TreeNode LCA = lowestCommonAncestor(root.right, p, q);
        //     if(LCA != null) return LCA;
        // }

        // return null;
 
        // if(isCommonAncestor(root, p, q)) return root;

        // return isCommonAncestor(root, p, q);
    }

    public boolean isCommonAncestor(TreeNode root,  TreeNode p, TreeNode q){

        System.out.println("I have root.val :: " + root.val);

        return (foundNode(root, p) && foundNode(root, q));
    }

    public boolean foundNode(TreeNode root, TreeNode p){

        if(root == null) return false;

        System.out.println(" -- checking val and p " + root.val + " " + p.val);

        if(root.val == p.val) return true;
 
        return foundNode(root.left, p) || foundNode(root.right, p);
    }
}