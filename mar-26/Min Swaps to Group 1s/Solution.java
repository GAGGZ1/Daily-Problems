
class Solution {
    public int minSwaps(int[] arr) {
        int countone=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                countone++;
            }
        }
        if(countone<1)return -1;
        int currone=0;
        for(int i=0;i<countone;i++){
            if(arr[i]==1){
                currone++;
            }
        }
        int maxone=currone;
        for(int i=countone;i<arr.length;i++){
            if(arr[i]==1){
                currone++;
            }
            if(arr[i-countone]==1){
                currone--;
            }
            maxone=Math.max(currone,maxone);
        }
        
        return countone-maxone;
    }
}
