/**

Time: O(n * m) where n is size of root tree and m is size of subtree.
Space: O(h_n + h_m) height of the root tree
 */

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

        // if we reach the end of the tree return false
        if(root == null) return false;

        //if we find the subtree in the main tree starting at position root, we return true
        // if(isSameTree(root, subRoot)) return true;

        // recursive call to find the subtree in left or right end. (we either find it and return true from a side or if both end and return false we return false)
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);

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