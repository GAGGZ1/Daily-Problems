import java.util.* ;
import java.io.*; 
public class Solution {
 static class Edge{
    int src;
    int dest;
    public Edge(int src,int dest){
      this.src=src;
      this.dest=dest;
    }
  }
   static ArrayList<Edge>[] buildGraph(ArrayList<ArrayList<Integer>> edges,int v){
      ArrayList<Edge>[]graph=new ArrayList[v+1];
    for(int i=0;i<v;i++){
      graph[i]=new ArrayList<>();
    }
    for(int i=0;i<edges.size();i++){
        int u=edges.get(i).get(0);
        int vv=edges.get(i).get(1);
        graph[u].add(new Edge(u,vv));
        
    }
    return graph;
    

  }
 static void dfs(ArrayList<Edge>[]graph,boolean[]visited,int curr,Stack<Integer>st){
    visited[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
      Edge e=graph[curr].get(i);
      if(!visited[e.dest]){
        dfs(graph,visited,e.dest,st);
      }
    }
    st.add(curr);
  }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {   ArrayList<Integer> arr=new ArrayList<>();
     
    ArrayList<Edge>[]graph=buildGraph(edges,v);
        boolean []visited=new boolean[v+1];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(graph,visited,i,st);
      }

    }
     while(!st.isEmpty()){
      arr.add(st.pop());
    }
    return arr;
    }
}
