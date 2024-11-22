/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode curr = queue.poll();

            if(curr == null){ 
                sb.append("#");
            }else {
                sb.append(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            }

            sb.append(",");
        }
        
        sb.setLength(sb.length() - 1);  //remember to chop off the last ','.
        System.out.println(sb.toString());
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() < 1) return null;

        Queue<TreeNode> stack = new LinkedList<>();

        String[] dataArr = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
        stack.add(root);

        for(int i=2; i < dataArr.length; i+=2){

            TreeNode curr = stack.poll();

            if(!dataArr[i-1].equals("#")){
                curr.left = new TreeNode(Integer.valueOf(dataArr[i-1]));
                stack.add(curr.left);
            }

            if(!dataArr[i].equals("#")){
                curr.right = new TreeNode(Integer.valueOf(dataArr[i]));
                stack.add(curr.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));