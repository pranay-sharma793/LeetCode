/**
check if both null (T), check if one is null (F), check vals else return balance(left) && balance(right)

Time: O(n + m) //size of both the trees. We can say it to be O(n), where n is the longer tree. 
Space: O(height_n + height_m) //can be just O(height) which is the height of the longest tree.
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