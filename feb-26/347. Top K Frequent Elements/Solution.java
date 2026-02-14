class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int i:map.keySet()){
            pq.offer(i);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[]res=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll();
        }
        return res;


    }
}