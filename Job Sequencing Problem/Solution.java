package Job Sequencing Problem;

public class Solution {
    class Pair{
        int val;
        int p;
        
        public Pair(int v,int p){
            this.val=v;
            this.p=p;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] d, int[] profit) {
        // code here
        ArrayList<Pair>pr=new ArrayList<>();
        for(int i=0;i<d.length;i++){
            pr.add(new Pair(d[i],profit[i]));
        }
        pr.sort((a, b) -> b.p - a.p);
        int ans=0;
        int max=0;
        for(int i=0;i<d.length;i++){
            if(d[i]>max){
                max=d[i];
            }
        }
        ArrayList<Integer>ls=new ArrayList<>();
        int count=0;
         boolean arr[]=new boolean [max+1];
        for(Pair pp:pr){
            int ded=pp.val;
            int pro=pp.p;
            
           for (int j = ded; j >= 1; j--) {
                if (!arr[j]) {
                    arr[j] = true;
                    ans += pro;
                    count++;
                    break;
                }
            }
        }
        
        
        ls.add(count);
       
        ls.add(ans);
        return ls;
        
    }
} {
  
}
