class Solution {
    public boolean col(int[][]grid){
        int c=grid[0].length;
        int r=grid.length;
        int[] sum= new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sum[j]+=grid[i][j];
            }
        }
        int currsum=0;
        int totalSum=0;
        for(int j=0;j<c;j++){
            totalSum+=sum[j];
        }
        int leftSum = 0;
        for(int j=0;j<c-1;j++){
            leftSum+=sum[j];
            int rightSum=totalSum-leftSum;
            if(leftSum==rightSum){
                return true;
            }
        }
        
        
        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        int sum=0;
        int r=grid.length;
        int c=grid[0].length;
        for(int[]row:grid){
            for(int val:row){
                sum+=val;
            }
        }
        int currsum=0;
        for(int i=0;i<r-1;i++){ 
            for(int j=0;j<c;j++){
                currsum+=grid[i][j];
            }
            if(currsum==sum-currsum){
                return true;
            }
        }
        if(col(grid)){
            return true;
        }
        return false;
    }
}
