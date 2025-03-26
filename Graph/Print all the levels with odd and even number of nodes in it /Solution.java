
import javax.xml.namespace.QName;


public class Solution {
  public static vodi bfs(Node root){
    int level=1;
    Queue<Node>q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty(())){
      int size=q.size();
      if (size % 2 == 0) {
        System.out.println("Level " + level + " (Even nodes): " + size);
    } else {
        System.out.println("Level " + level + " (Odd nodes): " + size);
    }
    for(int i=0;i<size;i++){
      Node curr=q.poll();
      for(Node child:curr.children){
        q.add(child);

    }
    level++;
    }
  }
}
