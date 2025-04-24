// Problem Statement :
// Given an array representing the level-order traversal of a binary tree, construct the tree and print the in-order predecessor and successor for each node in the array; if none exist, print 0.

// 🌳 Objective
// Given an array that represents a binary tree in level-order, you are:

// Building the binary tree from the array.

// Performing in-order traversal.

// Printing each node’s in-order predecessor and successor.

// If there's no predecessor/successor, print 0.

import java.util.*;
class Node{
  int val;
  Node left;
  Node right;

  Node(int val){
    this.val=val;
  } 
}
public class Solution{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int [n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    Node root=buildtree(arr,0);
    ArrayList<Node>ls=new ArrayList<>();
    inorder(root,ls);
    printval(arr,ls);
  }
  public static Node buildtree(int []arr,int i){
    if(i>=arr.length)return null;
    Node root=new Node(arr[i]);
    root.left=buildtree(arr,(2*i)+1);
    root.right=buildtree(arr,(2*i)+2);
    return root;
  }
  public static void inorder(Node root,ArrayList<Node>ls){
    if(root==null)return;
    inorder(root.left,ls);
    ls.add(root);
    inorder(root.right,ls);
  }
  public static void printval(int[]arr,ArrayList<Node>ls){
    HashMap<Integer,Integer>map=new HashMap<>();
    int n=ls.size();
    for(int i=0;i<n;i++){
      map.put(ls.get(i).val,i);
    }

    for(int i=0;i<arr.length;i++){
      int idx=map.get(arr[i]);
      int pred=(idx>0)?ls.get(idx-1).val:0;
      int succ=(idx<ls.size()-1)?ls.get(idx+1).val:0;
      System.out.print("Node "+arr[i]+" : "+pred+","+succ);
      System.out.println();
    }
  }


}
