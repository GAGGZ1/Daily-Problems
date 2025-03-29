class Solution {
  public int maximum69Number (int num) {
      String n = Integer.toString(num);
      StringBuilder sb=new StringBuilder();
      boolean flag=false;
      for(int i=0;i<n.length();i++){
          if(flag==false && n.charAt(i)=='6'){
              sb.append('9');
              flag=true;
          }
          else{
              sb.append(n.charAt(i));
          }
      }
      return Integer.parseInt(sb.toString());
  }
}