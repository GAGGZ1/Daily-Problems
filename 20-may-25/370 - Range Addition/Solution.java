import java.util.*;

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
      int ans[]=new int[length];
      for(int []u:updates){
        int s=u[0];
        int e=u[1];
        int v=u[2];
        ans[s]+=v;
        if(e+1<length){
          ans[e+1]-=v;
        }}
        for(int i=1;i<length;i++){
          ans[i]+=ans[i-1];
        }
      
    

      return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        // int length = 5;
        // int[][] updates = {
        //     {1, 3, 2},
        //     {2, 4, 3},
        //     {0, 2, -2}
        // };

         int length = 10;
        int[][] updates = {
          

        {2,4,6},{5,6,8},{1,9,-4}};

        int[] result = sol.getModifiedArray(length, updates);

        System.out.println("Modified Array: " + Arrays.toString(result));
    }
  }