
class Solution {
    public long largesSumCycle(int N, int Edge[]) {
        long maxsum=-1;
        
        boolean[]vis=new boolean[N];
        
        for(int i=0;i<N;i++){
            if(!vis[i]){
                
                int curr=i;
                HashMap<Integer,Integer>map=new HashMap<>();
                int step=0;
                
                while(curr!=-1 && !vis[curr]){
                    
                    if(map.containsKey(curr)){
                        int currsum=0;
                        //work
                        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
                            if(entry.getValue()>=map.get(curr)){
                                currsum+=entry.getKey();
                            }
                        }
                        maxsum=Math.max(maxsum,currsum);
                        break;
                    }
                    if (vis[curr]) break;

                    map.put(curr, step++);
                    curr = Edge[curr];
                    
                    
                
                    
                    //work
                }for (int node : map.keySet()) {
                    vis[node] = true;
                }
            }
        }
        return maxsum;
    }
}