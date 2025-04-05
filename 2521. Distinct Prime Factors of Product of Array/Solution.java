class Solution {
  public boolean isPrime(int n){
      int count=0;
      for(int i=1;i<=n;i++){
          if((n%i)==0){
              count++;
          }
          if(count>2){
              return false;
          }
      }
      return true;
  }
  public int distinctPrimeFactors(int[] nums) {
      int ans=0;
      int n=nums.length;
      HashSet<Integer>set=new HashSet<>();
      for(int i=0;i<n;i++){
          if(isPrime(nums[i])){
              
              set.add(nums[i]);
          }
     
           
          else{
              int number=2;
              while(nums[i]!=1){
                  if(nums[i]%number==0){
                      set.add(number);
                      nums[i]=nums[i]/number;
                  }
                  else{
                  number=number+1;
                      while(!isPrime(number)){
                          number++;
                      }
                  }
              }
          }
      }
      return set.size();
  }
}