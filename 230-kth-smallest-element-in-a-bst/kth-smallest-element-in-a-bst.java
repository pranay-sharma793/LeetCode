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
    int ans = -1;
    int val = -1;
    public int kthSmallest(TreeNode root, int k) {

        // List<Integer> list = new ArrayList<>();

        // performInorderDFS(root, list);
        val = k;

        returnKth(root);

        return ans;
        // return list.get(k-1);
        
    }

    private void performInorderDFS(TreeNode root, List<Integer> list){

        if(root == null) return;

        performInorderDFS(root.left, list);
        list.add(root.val);
        performInorderDFS(root.right, list);

    }

    private void returnKth(TreeNode root){

        if(root == null) return;

        returnKth(root.left);
        val--;
        if(val == 0) {
            ans = root.val;
            return;
        }
        returnKth(root.right);

    }
}
