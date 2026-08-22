class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int visi[]=new int[n];
     
        return isPath(graph,source,destination,visi);
    }
    public boolean isPath(List<List<Integer>>graph,int src,int dest,int visi[]){
        if(visi[src]==1)return false;
        if(src==dest){return true;}
         visi[src]=1;
       

        for(int n:graph.get(src)){
            
            boolean ans=isPath(graph,n,dest,visi);
            if(ans==true){
                return true;
            }
        }
        return false;
    }
}