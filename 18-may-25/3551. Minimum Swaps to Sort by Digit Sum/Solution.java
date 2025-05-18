public class Solution {
  public class checksort implements Comparable<checksort>{
    int v;
    public checksort(int v){
      this.v=v;
    }
    public int digitSum(int n){
      int sum=0;
      while(n>0){
        sum+=n%10;
        n=n/10;
      }
      return sum;
    }
    @Override
    public int compareTo(checksort other){
      int thisSum=digitSum(this.v);
      int otherSum=digitSum(other.v);
      if(thisSum!=otherSum){
        return Integer.compare(thisSum,otherSum);
      }else{
        return Integer.compare(this.v,other.v);
      }
    }
  }
     public int digi(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
  public int minSwaps(int[] nums){
        int n = nums.length;
        List<checksort> list=new ArrayList<>();
        for(int num:nums){
            list.add(new checksort(num));
        }
        Collections.sort(list);
        int[] temp=new int[nums.length];
        for(int i=0;i<list.size();i++){
            temp[i]=list.get(i).v;
        }
      boolean []used=new boolean[n];
        // System.out.println(Arrays.toString(temp));

        HashMap<Integer, Integer>pos = new HashMap<>();
        for (int i = 0; i < n; i++) 
            pos.put(nums[i], i);
      boolean[]vis=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++){
            if(vis[i]|| pos.get(temp[i])==i){
                continue;
            }
            int j=i;
            int cyclesize=0;
            while(!vis[j]){
                vis[j]=true;
                j=pos.get(temp[j]);
                cyclesize++;
            }
            if(cyclesize>0)swaps+=cyclesize-1;
        }
        return swaps;
    }

}