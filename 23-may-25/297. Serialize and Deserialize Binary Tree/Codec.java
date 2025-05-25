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
    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();

    }

    int idx = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return helper2(nodes);
    }

    public TreeNode helper2(String[]arr){
        if(idx>=arr.length || arr[idx].equals("null")){

idx++;
return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(arr[idx]));
        idx++;
        root.left=helper2(arr);
        root.right=helper2(arr);
        return root;
    
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));