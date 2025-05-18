import java.util.*;

public class Solution{
  static class Pair{
    TreeNode node;
    int val;

    public Pair(TreeNode node,int val){
      this.node=node;
      this.val=val;
    }
  }
  static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
      this.val=val;
    }
  }
  
  public static void traversal(TreeNode root, ArrayList<Integer>pre, ArrayList<Integer>in, ArrayList<Integer>post){
    if(root==null)return;
    Stack<Pair>st=new Stack<>();
    st.push(new Pair(root,1));
    while(!st.isEmpty()){
      Pair p=st.pop();
      TreeNode curr=p.node;
      int v=p.val;
      if(v==1){
        pre.add(curr.val);
        v++;
        st.push(new Pair(curr,v));
        if(curr.left!=null)
        st.push(new Pair(curr.left,1));
      }
      else if(v==2){
        in.add(curr.val);
        v++;
        st.push(new Pair(curr,v));
        if(curr.right!=null)
        st.push(new Pair(curr.right,1));
      }
      else{
        post.add(curr.val);
      }
    }
  }
  public static void main(String[] args) {
    ArrayList<Integer>pre=new ArrayList<>();
    ArrayList<Integer>in=new ArrayList<>();
    ArrayList<Integer>post=new ArrayList<>();
    TreeNode root=new TreeNode(2);
    //complete tree
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    traversal(root,pre,in,post);
    System.out.println("pre="+pre);
    System.out.println("in="+in);
    System.out.println("post="+post);
  }

}