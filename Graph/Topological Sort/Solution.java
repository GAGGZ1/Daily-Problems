import java.util.*;
public class Solution{
  static class Edge{
    int src;
    int dest;
    public Edge(int src,int dest){
      this.src=src;
      this.dest=dest;
    }
  }
  public static void buildGraph(ArrayList<Edge>[]graph){
    for(int i=0;i<graph.length;i++){
      graph[i]=new ArrayList<>();
    }
    graph[2].add(new Edge(2,3));
    graph[3].add(new Edge(3,1));
    graph[4].add(new Edge(4,0));
    graph[4].add(new Edge(4,1));
    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));

  }
  public static void main(String[] args) {
    int v=6;
    ArrayList<Edge> graph[]=new ArrayList[v];
    buildGraph(graph);
    boolean []visited=new boolean[v];
    Stack<Integer>st=new Stack<>();
    for(int i=0;i<v;i++){
      if(!visited[i]){
        dfs(graph,visited,i,st);
      }
    }

    while(!st.isEmpty()){
      System.out.print(st.pop() +" ");
    }
  }
  public static void dfs(ArrayList<Edge>[]graph,boolean[]visited,int curr,Stack<Integer>st){
    visited[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(!visited[e.dest]){
        dfs(graph,visited,e.dest,st);
      }
    }
    st.add(curr);
  }
}