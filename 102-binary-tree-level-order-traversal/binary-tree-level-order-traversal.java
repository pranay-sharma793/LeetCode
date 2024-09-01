/**
BFS applied with looping all nodes in the queue at a given level. 


Time: O(n)
Space: O(n)
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;


        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> levelNode = new ArrayList<>();

            for(int i = 0; i < n; i++){
                TreeNode curr = queue.poll();

                levelNode.add(curr.val);

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);

            }

            result.add(levelNode);
        }

        return result;
        
    }
}