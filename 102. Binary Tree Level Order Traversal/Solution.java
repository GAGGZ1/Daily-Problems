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
      List<List<Integer>> res=new ArrayList<>();
      if(root==null){
          return res;
      }
      Queue<TreeNode>q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
          int size=q.size();
          ArrayList<Integer>curr=new ArrayList<>();
          for(int i=0;i<size;i++){
              TreeNode n=q.poll();
              curr.add(n.val);
              if(n.left!=null){
                  q.add(n.left);
              }
              if(n.right!=null){
                  q.add(n.right);
              }
          }
          res.add(curr);
      }
      return res;

  }
}