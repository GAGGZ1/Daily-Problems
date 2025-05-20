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
    public TreeNode bstFromPreorder(int[] po) {
        int n =po.length;
        TreeNode root=null;
        for(int i=0;i<n;i++){
            root=solve(po,i,root);
        }
        return root;
    }

    public TreeNode solve(int[] arr, int i,TreeNode root) {
        
        if(root==null){
            root=new TreeNode(arr[i]);
            return root;
        }

        if(arr[i]<root.val){
            root.left=solve(arr,i,root.left);
        }
        else{
            root.right=solve(arr,i,root.right);
        }
        return root;


    }
}