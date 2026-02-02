class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        ArrayList<Integer>arr1=new ArrayList<>();
        int max=0;
        int min=0;
        int n=arr.length;
        int i=0;
        if(n%2==0){
            if(arr[0]>arr[1]){
                max=arr[0];
                min=arr[1];
            }else{
                min=arr[0];
                max=arr[1];
            }
            i=2;
        }
        else{
            min=max=arr[0];
            i=1;
        }
        
       while(i<n-1){
           int min1=0;
           int max1=0;
           if(arr[i]>arr[i+1]){
               max1=arr[i];
               min1=arr[i+1];
           }else{
               max1=arr[i+1];
               min1=arr[i];
           }
           
           max=Math.max(max1,max);
           min=Math.min(min1,min);
           i+=2;
       }
       arr1.add(min);
       arr1.add(max);
       return arr1;
       
        
    }
}
