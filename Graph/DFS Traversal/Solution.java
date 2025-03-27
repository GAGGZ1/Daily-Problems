import java.util.ArrayList;

public class Solution {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static  ArrayList<Edge>[] buildGraph(int v,ArrayList<ArrayList<Integer>> edges){
        ArrayList<Edge>[]graph=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.size();i++){
           int u= edges.get(i).get(0);
           int vv= edges.get(i).get(1);
           graph[u].add(new Edge(u,vv));
           graph[vv].add(new Edge(vv,u));
        }
        
        return graph;
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<Edge>[]graph=buildGraph(v,edges);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
       
        boolean[]visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                ArrayList<Integer>ans=new ArrayList<>();
                solve(i,v,graph,ans,visited);
                result.add(ans);
        }
        }
           
        return result;
    }
    public static void solve(int curr,int v, ArrayList<Edge>[] graph, 
    ArrayList<Integer>ans, boolean[]visited){
        visited[curr]=true;
        ans.add(curr);
        
        for(Edge e:graph[curr]){
            int dest=e.dest;
            if(!visited[dest]){
                

                solve(dest,v,graph,ans,visited);
            }
        }
    }
}