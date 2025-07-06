class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0;
        int j=0;
        int currplt=0;
        int maxplt=0;
        while(i<arr.length && j<dep.length){
            if(arr[i]<=dep[j]){
                i++;
                currplt++;
            }else{
                currplt--;
                j++;
            }
            maxplt=Math.max(maxplt,currplt);
        }
        return maxplt;
    }
}
