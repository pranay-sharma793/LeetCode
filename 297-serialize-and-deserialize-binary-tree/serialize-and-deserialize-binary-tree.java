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

    public String serialize(TreeNode root) {
        if(root == null) return "$";
        return root.val + "," + serialize(root.left) +  "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue){
        String curr = queue.poll();
        if(curr.equals("$")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(curr));

        root.left = helper(queue);
        root.right = helper(queue);

        return root;
    }



    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.val == 1001) sb.append("$,");
            else sb.append(curr.val + ",");

            if(curr.val == 1001) continue;

            if(curr.left != null) q.add(curr.left);
            else q.add(new TreeNode(1001));

            if(curr.right != null) q.add(curr.right);
            else q.add(new TreeNode(1001));
        }

        sb.setLength(sb.length() - 1);
        // System.out.println(sb.toString());

        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {

        System.out.println(data);

        if(data.length() == 1 ) return null;

        String[] dataArr = data.split(",");
        
        TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for(int i = 2; i < dataArr.length; i+=2){
            TreeNode curr = q.poll();

            // System.out.println("i, curr, left, right " + i + " " + curr.val  + " " + dataArr[i-1]  + " " + dataArr[i]);
            
            if(!dataArr[i-1].equals("$")){
                curr.left = new TreeNode(Integer.valueOf(dataArr[i-1]));
                q.add(curr.left);
            } else curr.left = null;

            if(!dataArr[i].equals("$")){
                curr.right = new TreeNode(Integer.valueOf(dataArr[i]));
                q.add(curr.right);
            }else curr.right = null;

        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));