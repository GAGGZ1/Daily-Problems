import java.util.*;

public class Solution {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class Binarytree {
    static int idx = -1;

    public static Node buildTree(int nodes[]) {
      idx++;
      if (nodes[idx] == -1) {
        return null;
      }
      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }
  }

  public static void preorder(Node root) {
    if (root == null)
      return;

    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void inorder(Node root) {
    if (root == null)
      return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static void postorder(Node root) {
    if (root == null)
      return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data + " ");

  }

  public static void levelorder(Node root) {

    if (root == null)
      return;

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      Node curr = q.remove();
      if (curr == null) {
        System.out.println();
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        
        }
      }

      else {
        System.out.print(curr.data + " ");
        if (curr.left != null) {
          q.add(curr.left);
        }
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
    }
  }
  public static int countNodes(Node root){
    if(root==null){
      return 0;
    }
    int left=countNodes(root.left);
    int right=countNodes(root.right);

    return left+right+1;
  }

  public static int sumNodes(Node root){
    if(root==null)return 0;

    int left=sumNodes(root.left);
    int right=sumNodes(root.right);

    return left+right+root.data;
  }

  public static int heightTree(Node root){
    if(root==null)return 0;
    int left=heightTree(root.left);
    int right=heightTree(root.right);

    int maxheight=Math.max(left,right)+1;
    return maxheight;
  }
  public static int diameter(Node root){
    if(root==null)return 0;
    int d1=diameter(root.left);
    int d2=diameter(root.right);

    int d3=heightTree(root.left)+heightTree(root.right)+1;

    return Math.max( Math.max(d1,d2),d3);
  }

  static class Treeinfo{
    int ht=0;
    int dia=0;
    
    public Treeinfo(int ht,int dia){
      this.ht=ht;
      this.dia=dia;
    }

  }

  public static Treeinfo diameter2(Node root){

    if(root==null)return new Treeinfo(0,0);

    Treeinfo left=diameter2(root.left);
    Treeinfo right=diameter2(root.right);
    
    int myht=Math.max(left.ht,right.ht)+1;

    int d1=left.dia;
    int d2=right.dia;
    int d3=left.ht+right.ht+1;

    int mydia=Math.max(Math.max(d1,d2),d3);

    Treeinfo myinfo=new Treeinfo(myht, mydia);
    return myinfo;



  }
  public int kthlevel(Node root,int k){
    int level=1;
    Queue<Node>q=new LinkedList<>();

    q.add(root);
    
    while(!q.isEmpty()){
      int size=q.size();
      int sum=0;
      for(int i=0;i<size;i++){
        Node curr=q.poll();

        if(level==k){
          sum+=curr.data;
        }
        if(curr.left!=null){
          q.add(curr.left);
        }
        if(curr.right!=null){
          q.add(curr.right);
        }
      }
      if(level==k){
        return sum;
      }
     
      level++;

  }
  return 0;
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    Binarytree tree = new Binarytree();
    Node root = tree.buildTree(nodes);
    // System.out.println(root.data);
    // preorder(root);
    // System.out.println();
    // inorder(root);
    // System.out.println();
    // postorder(root);
    // levelorder(root);
    // System.out.println(countNodes(root));
    // System.out.println(sumNodes(root));
    // System.out.println(heightTree(root));
    // System.out.println(diameter(root));
    System.out.println(diameter2(root).dia);
  }
}