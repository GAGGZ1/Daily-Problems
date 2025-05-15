import java.util.*;
public class Solution{
  static class Node{
    int val;
    int flag;
    Node left;
    Node right;

    public Node(int val,int flag){
      this.val=val;
      this.flag=flag;
    }
  }
  public static void main(String args[]){
    //work
    int [][]edges={
      {1,2},
      {1,3},

      {2,4},
      {2,5},
      {3,6},
      {3,7}
    };
    Map<Integer,Integer>flags=Map.of(
      1,1,2,0,3,1,4,1,5,0,6,0,7,0
    );
    Node root=buildTree(edges,flags);
    int maxObs=1;
    int count=validPathCount(root,0,1);
    System.out.println("count = "+ count);


  }
  public static Node buildTree(int[][]edges,Map<Integer,Integer>flags){
    HashMap<Integer,Node>map=new HashMap<>();
    Set<Integer>set=new HashSet<>();
    
    for(int e[]:edges){
      int parVal=e[0];
      int chiVal=e[1];

      Node parent=map.getOrDefault(parVal,new Node(parVal,flags.get(parVal)));
      Node child=map.getOrDefault(chiVal,new Node(chiVal,flags.get(chiVal)));

      // if(parent==null){
      //   //not possible as declared in above ;
      // }

      if(parent.left==null){
        parent.left=child;
      }
      else if(parent.right==null){
        parent.right=child;
      }
      map.put(parVal,parent);
      map.put(chiVal,child);
      set.add(chiVal);
    }
    for(int val:map.keySet()){
      if(!set.contains(val)){
        return map.get(val);
      }
    }
    return null;
  }
  public static int validPathCount(Node root,int currConsObs,int maxObs){
    if(root==null)return 0;

    if(root.flag==1){
      currConsObs++;
    }
    else{
      currConsObs=0;
    }
    

    if(currConsObs>maxObs){
      return 0;
    }

    if(root.left==null && root.right==null){
      return 1;
    }

    return validPathCount(root.left,currConsObs,maxObs)+ validPathCount(root.right,currConsObs,maxObs);
    
  }


}