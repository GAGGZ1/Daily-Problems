class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer>q=new LinkedList<>();
        List<Integer>ls=new ArrayList<>();
        int i=0;
        
        int j=0;
        while(j<arr.length){
            
            if(arr[j]<0){
                q.add(j);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                
                if(q.isEmpty()){
                    ls.add(0);
                }else{
                    ls.add(arr[q.peek()]);
                }
                if(!q.isEmpty() && q.peek()==i){
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return ls;
    }
}