class Solution {
    int maxLen(int arr[]) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int presum=0;
        int maxlen=0;
        for(int i=0;i<arr.length;i++){
            presum+=arr[i];
            if(presum==0){
                maxlen=i+1;
            }
            if(map.containsKey(presum)){
                maxlen=Math.max(maxlen,i-map.get(presum));
            }else{
                map.put(presum,i);
            }
        }
        return maxlen;
        
    }
}