class Solution {
  public int minimumPartition(String s, int k) {
      
      int n = s.length();
   
      long[] arr = new long[s.length()];

      for (int i = 0; i < s.length(); i++) {
          arr[i] = s.charAt(i) - '0';
      }
      for(int i=0;i<n;i++){
          System.out.print(arr[i]+ " ");
      }
      System.out.println();
      int count = 0;
      boolean flag = false;
      long number = 0;
      HashSet<Long> set = new HashSet<>();

      for (int i = 0; i < n; i++) {
          System.out.println("number ="+number);
          if (arr[i] > k) {
              return -1;
          }
          number = (number * 10 )+ arr[i];
          if (number > k) {
              count++;
              set.add(number/10);
              number = arr[i];
          }

      }
      if (number > 0)
          count++;
      return count;

  }
}