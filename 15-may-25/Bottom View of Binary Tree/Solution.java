import java.util.ArrayList;
import java.util.Queue;

public class Solution {
  class Pair{
    Node node;
    int hd=0;

    public Pair(Node node,int hd){
      this.node=node;
      this.hd=hd;
    }


  }
   public ArrayList<Integer> bottomView(Node root) {
    ArrayList<Integer>res=new ArrayList<>();
    if(root==null){
      return res;
    }
    TreeMap<Integer,Integer>map=new TreeMap<>();
    Queue<Pair>q=new LinkedList<>();
    q.add(new Pair(root,0));
    while(!q.isEmpty()){
      Pair curr=q.poll();
      Node node=curr.node;
      int hd=curr.hd;

      map.put(hd,node.data);

      if(node.left!=null){
        q.add(new Pair(node.left,hd-1));
      }
      if(node.right!=null){
        q.add(new Pair(node.right,hd+1));
      }
    }
    for(int val:map.values()){
      res.add(val);
    }
    return res;
   }
}
