// import java.util.*;
// class Solution {
//   static ArrayList<Integer> largestSquare(ArrayList<ArrayList<Integer>> M, int R,
//       int C, int K, int Q,
//       int[] q_i, int[] q_j) {
//     // code here

//     ArrayList<Integer> ls = new ArrayList<>();

//     for (int q = 0; q < Q; q++) {
//       int i = q_i[q];
//       int j = q_j[q];
//       int min_dist = Math.min((Math.min(i, j)),
//           (Math.min(
//               (R - i - 1),

//               (C - j - 1)

//           )));
//       int ans = -1;

//       int low = 0, high = min_dist;

//       while (low <= high) {
//         int mid = (low + high) / 2;
//         int count = 0;

//         for (int row = i - mid; row <= i + mid; row++) {
//           for (int col = j - mid; col <= j + mid; col++) {
//             count += M.get(row).get(col);
//           }
//         }

//         if (count <= K) {
//           ans = (2 * mid) + 1; // update answer, try to go larger
//           low = mid + 1;
//         } else {
//           high = mid - 1; // too big, try smaller
//         }
//       }
//       if (ans == -1)
//         ans = 0;
//       ls.add(ans);

//     }
//     return ls;

//   }
// };


// practice

import java.util.*;
class Solution {
  static ArrayList<Integer> largestSquare(ArrayList<ArrayList<Integer>> M, int R,int C, int K, int Q,int[] q_i, int[] q_j) {
    ArrayList<Integer>ls=new ArrayList<>();
    for(int q=0;q<Q;q++){
      int i=q_i[q];
      int j=q_j[q];
      int min_dist=Math.min(Math.min(i,j) ,Math.min(R-i-1,C-j-1));

      int ans=-1;

      int low=0;
      int high=min_dist;
      while(low<high){
        int mid=low+(high-low)/2;
        int count=0;
        for(int row=i-mid;row>=i+mid;row++){
          for(int col=j-mid;col>=j+mid;col++){
            count+=M.get(row).get(col);
          }
        }
        if(count<=K){
          ans=mid;
          low=mid+1;
        }
        else{
          high=mid-1;
        }
      }
      if(ans==-1)ans=0;
      ls.add(ans);
    }
    return ls;
  
  }
}