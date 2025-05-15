import java.util.*;
public class Solution{
  static class Node{
    int val;
    Node left;
    Node right;

    public Node(int val){
      this.val=val;
    }
  }
  public static void main(String[] args) {
    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int x = 5;
        validPath(root, x);
  }
  public static void validPath(Node root,int x){
  ArrayList<Integer> path = new ArrayList<>();
        if (pathtoTarget(root, x, path)) {
            System.out.println("Path from root to " + x + ": " + path);
        } else {
            System.out.println("Node " + x + " not found in the tree.");
        }
  }
  public static boolean pathtoTarget(Node root,int x,ArrayList<Integer>res){
    if(root==null)return false;
    res.add(root.val);
    if(root.val==x){
      return true;

    }
   if(pathtoTarget(root.left, x, res) || pathtoTarget(root.right, x, res)){
    return true;
   }
   res.remove(res.size()-1);
   return false;
  }
}