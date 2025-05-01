import java.util.*;
class ProductOfNumbers {
  ArrayList<Integer>ls;
  public ProductOfNumbers() {
      ls=new ArrayList<>();
      ls.add(1);
  }
  
  public void add(int num) {
      if(num==0){
          ls=new ArrayList<>();
          ls.add(1);

      }
      else{
          int n=ls.size();
          ls.add(ls.get(n-1)*num);
      }
  }
  
  public int getProduct(int k) {
      int n=ls.size();
      if(k>=n)return 0;
      return ls.get(n-1)/ls.get(n-k-1);
  }
}

/**
* Your ProductOfNumbers object will be instantiated and called as such:
* ProductOfNumbers obj = new ProductOfNumbers();
* obj.add(num);
* int param_2 = obj.getProduct(k);
*/