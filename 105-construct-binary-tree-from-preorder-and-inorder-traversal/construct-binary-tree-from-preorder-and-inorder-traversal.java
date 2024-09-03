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

    private HashMap<Integer, Integer> inorderIndexMap;
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        
        for(int val : inorder){
            inorderIndexMap.put(val , preIndex++);
        }

        // for (int i = 0; i < inorder.length; i++) {
        //     inorderIndexMap.put(inorder[i], i);
        // }
     
        preIndex = 0;
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Get the current root value and increment preIndex
        // int rootVal = preorder[preIndex++];
        // TreeNode root = new TreeNode(rootVal);

        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Get the index of the current root in inorder traversal
        int inIndex = inorderIndexMap.get(root.val);

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inIndex + 1, inEnd);

        return root;
    }




    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        return helper(0, 0, inorder.length-1, preorder, inorder);
        
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){

        if(preStart > preorder.length-1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = 0;
        for(int i = 0; i <= inEnd; i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }

        root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);

        return root;
    }
}