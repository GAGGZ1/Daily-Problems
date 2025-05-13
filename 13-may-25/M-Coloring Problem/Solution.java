
class Solution {
    class Edge{
        int src;
        int dest;
        
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
           
        }
    }
    public ArrayList<Edge>[] build(int [][]edges,int V){
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
        return graph;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        ArrayList<Edge>[]graph=build(edges,v);
        int[]color=new int[v];
        
        return solve(0,v,graph,m ,color);
        
    }
    
    public  boolean solve(int curr,int V,ArrayList<Edge>[]graph,int m,int[] color){
        if(curr==V){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isSafe(curr,i,graph,color)){
                color[curr]=i;
                
                if(solve(curr+1,V,graph,m,color))
                return true;
                color[curr]=0;
            }
        }
        return false;
        
    }
    public boolean isSafe(int curr,int c,ArrayList<Edge>[] graph, int[] color){
        
       for(Edge e:graph[curr]){
           if(color[e.dest]==c){
               return false;
           }
       }
       return true;
    }
    
}