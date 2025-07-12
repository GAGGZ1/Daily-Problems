class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int n=a.length;
        
        PriorityQueue<int[]>maxHeap=new PriorityQueue<>((x,y)->(y[0]-x[0]));
        Set<String>visited=new HashSet<>();
        int i=n-1;
        int j=n-1;
        maxHeap.offer(new int[]{a[i]+b[j],i,j});
        visited.add(i+","+j);
        ArrayList<Integer>result=new ArrayList<>();
        while(k-->0 && !maxHeap.isEmpty()){
            int[]top=maxHeap.poll();
            int sum=top[0];
            int x=top[1];
            int y=top[2];
            result.add(sum);
            
            if(x-1>=0){
                String key1=(x-1)+","+y;
                if(!visited.contains(key1)){
                    maxHeap.offer(new int[]{a[x-1]+b[y],x-1,y});
                    visited.add(key1);
                }
            }
            if(y-1>=0){
                String key2=x+","+(y-1);
                if(!visited.contains(key2)){
                    maxHeap.offer(new int[]{a[x]+b[y-1],x,y-1});
                    visited.add(key2);
                }
            }
        }
        return result;
        
    }
}