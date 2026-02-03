class Solution {
    public ArrayList<Integer> prefSum(int[] arr) {
        // code here
        int currsum=arr[0];
        ArrayList<Integer>ls=new ArrayList<>();
        ls.add(currsum);
        for(int i=1;i<arr.length;i++){
            currsum+=arr[i];
            ls.add(currsum);
        }
        return ls;
    }
}