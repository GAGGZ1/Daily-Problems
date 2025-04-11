class Solution {
  public String binStr(int num) {
      StringBuilder sb = new StringBuilder();
      int n = num;
      while (n > 1) {
          int rem = n % 2;
          sb.append(rem);
          n = n / 2;
      }
      sb.append(1);
      return sb.reverse().toString();
  }

  public String convertDateToBinary(String s) {
      int n1 = Integer.parseInt(s.substring(0, 4));
      int n2 = Integer.parseInt(s.substring(5, 7));
      int n3 = Integer.parseInt(s.substring(8, 10));
      StringBuilder sb = new StringBuilder();
      sb.append(binStr(n1));
      sb.append('-');
      sb.append(binStr(n2));
      sb.append('-');
      sb.append(binStr(n3));
      return sb.toString();

  }
}