class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int count=1;
        int max=0;
        for(int i:set){
            if(set.contains(i-1)){
                continue;
            }else{
              int  num=i+1;
                while(set.contains(num)){
                    count++;
                    num++;
                }
                max=Math.max(count,max);

                count=1;
            }
        }
        return max;
    }
}