import java.util.Scanner;
import java.util.ArrayList;
class Node{
  int val;
  Node left;
  Node right;

  Node(int val){
    this.val=val;
    this.left=null;
    this.right=null;
  }
}

public class Main {
  public  static Node buildTree(int []arr,int i){
    if(i>=arr.length || arr[i]==-1){
      return null;
    }
    Node root=new Node(arr[i]);

    root.left=buildTree(arr,2*i+1);
    root.right=buildTree(arr,2*i+2);
    return root;
    
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the height of the tree: ");
    int h=sc.nextInt();
    int n=(int)Math.pow(2,h+1)-1;
    int arr[]=new int[n];
    System.out.println("Enter the elements of the tree (in level order): ");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    Node root = buildTree(arr,0);
    ArrayList<Integer>path=new ArrayList<>();
    ArrayList<ArrayList<Integer>>res=new ArrayList<>();
    solve(root,path,res);
    for(ArrayList<Integer>list:res){
      for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
      }
      System.out.println();
    }

  }
  public static void solve(Node root,ArrayList<Integer>path,ArrayList<ArrayList<Integer>>res){
    if(root==null){
      return;
    }
    path.add(root.val);
    if(root.left==null && root.right==null){
      res.add(new ArrayList<>(path));
    }
    else{
      solve(root.left,path,res);
      solve(root.right,path,res);

    }
    path.remove(path.size()-1);
    
  }
  
}
