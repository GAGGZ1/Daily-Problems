class Solution {
  public int maxProduct(int n) {
      ArrayList<Integer>ls=new ArrayList<>();
      while(n>0){
          ls.add(n%10);
          n=n/10;
      }
      Collections.sort(ls);
      return ls.get(ls.size()-1)*ls.get(ls.size()-2);
  }
}