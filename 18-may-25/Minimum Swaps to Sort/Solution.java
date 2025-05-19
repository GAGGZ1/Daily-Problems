
class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        // Code here
        int []temp=arr.clone();
        int n=arr.length;
        Arrays.sort(temp);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            if(temp[i]!=arr[i]){
                int idx=map.get(temp[i]);
                
                int tempval=arr[i];
                arr[i]=arr[idx];
                arr[idx]=tempval;
                
                map.put(arr[i],i);
                map.put(arr[idx],idx);
                swaps++;
            }
        }
        return swaps;
        
    }
}
