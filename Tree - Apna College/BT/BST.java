import java.util.*;
public class BST{
  
  static class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
      this.data=data;
      this.left=null;
      this.right=null;
    }


}
public static Node insert(Node root,int val){
  if(root==null){
    root=new Node(val);
    return root;
  }

  if(root.data>val){
    root.left=insert(root.left, val);
  }
  else{
    root.right=insert(root.right, val);
  }
  return root;
}
public static void  inorder(Node root){
  if(root==null)return;
  inorder(root.left);
  System.out.print(root.data+" ");
  inorder(root.right);
}

public static boolean search(Node root,int key){
  if(root==null)return false;
  if(root.data>key){
    return search(root.left, key);
  }
  else if(root.data==key){
    return true;
  }
  else{
    return search(root.right, key);
  }
}

public static Node delete(Node root,int val){
  if(root.data>val){
    root.left=delete(root.left, val);
  } else if(root.data<val){
    root.right=delete(root.right, val);
  }
  else{

    //case 1
    if(root.left==null && root.right==null){
      return null;
    }


    //case 2
    if(root.left==null){
      return root.right;
    }else if(root.right==null){
      return root.left;
    }

    //case 3

    Node IS=inorderSuccessor(root.right);
    root.data=IS.data;
    root.right=delete(root.right, IS.data);

  }
  return root;
}

public static Node inorderSuccessor(Node root){
  while(root.left!=null){
   root= inorderSuccessor(root.left);
  }
  return root;
}

public static void printInRange(Node root,int x,int y){
  if(root==null){

    return;
  }
  if(root.data>=x && root.data<=y){
    printInRange(root.left, x, y);
    System.out.print(root.data+" ");
    printInRange(root.right, x, y);
  }
  else if(root.data>=y){
    printInRange(root.left, x, y);
  }else{
    printInRange(root.right, x, y);
  }
}

public static void printPath(ArrayList<Integer>path){
  for(int i=0;i<path.size();i++){
    System.out.print(path.get(i)+"->");

  }
  System.out.println();
}

public static void printRoot2Leaf(Node root,ArrayList<Integer>path){
  if(root==null){
    return;
  }
  path.add(root.data);

  //leaf
  if(root.left==null && root.right==null){
    printPath(path);
   
  }
  else{
    printRoot2Leaf(root.left, path);
    printRoot2Leaf(root.right, path);
  }
  path.remove(path.size()-1);
}



public static void main(String[]args){
  int val[]={5,1,3,4,2,7};
  int values[]={8,5,3,1,4,6,10,11,14};
  Node root=null;
  // for(int i=0;i<val.length;i++){
  //   root=insert(root, val[i]);
  // }
  for(int i=0;i<values.length;i++){
    root=insert(root, values[i]);
  }
  // inorder(root);
  // // System.out.println(search(root, 0));
  // // System.out.println(search(root, 3));
  // if(search(root, 7)){
  //   System.out.println("Found");
  // }
  // else{
  //   System.out.println("not found");
  // }
  // delete(root,10);
  // inorder(root);
  // printInRange(root, 3, 10);
  printRoot2Leaf(root, new ArrayList<>());
}
}