import java.util.*;

public class Solution {
  public static List<Integer>findShortestPath(int v,int[][]edges,int s,int d){
    List<List<Integer>>adj=new ArrayList<>();
    for(int i=0;i<v;i++){
      adj.add(new ArrayList<>());
    }
    for(int []edge:edges){
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    int dist[]=new int[v];
    int parent[]=new int[v];
    Queue<Integer>q=new LinkedList<>();
    Arrays.fill(parent,-1);
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[s]=0;
    q.add(s);

    while(!q.isEmpty()){
      int u=q.poll();
      if(u==d){
        break;
      }
      for(int neighbor:adj.get(u)){
        if(dist[neighbor]==Integer.MAX_VALUE){
          dist[neighbor]=dist[u]+1;
          parent[neighbor]=u;
          q.add(neighbor);
        }
      }
    }

    //path creation
    List<Integer>path=new ArrayList<>();
    if(dist[d]==Integer.MAX_VALUE){
      return path;
    }
    int currentNode=d;
    while(currentNode!=-1){
      path.add(currentNode);
      currentNode=parent[currentNode];
    }

    Collections.reverse(path);
    return path;

  }
  public static void  main(String[]args){
    int v=8;
    int e=10;
    int s=2;
    int d=6;
    int[][]edges={{0, 1}, {1, 2}, {0, 3}, {3, 4}, {4, 7}, {3, 7}, {6, 7}, {4, 5}, {4, 6}, {5, 6}};
    List<Integer>shortestPath=findShortestPath(v, edges, s, d);
    if(shortestPath.isEmpty()){
      System.out.println("No Path found from "+s+" to "+d);
    }else{
      System.out.println("Shortest path from "+s+" to "+d+":");
      for(int i=0;i<shortestPath.size();i++){
        System.out.print(shortestPath.get(i)+ (i == shortestPath.size() - 1 ? "" : " -> "));
      }
    }



  }
}
