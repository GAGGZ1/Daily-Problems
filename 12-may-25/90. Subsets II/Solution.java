class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,new ArrayList<>(),res,0);
        return res;
    }
    public void solve(int []nums,List<Integer>curr,List<List<Integer>>res,int s){
        res.add(new ArrayList<>(curr));

        for(int i=s;i<nums.length;i++){
           if(i>s && nums[i]==nums[i-1])continue;
           curr.add(nums[i]);
           solve(nums,curr,res,i+1);
           curr.remove(curr.size()-1);
        }
    }
}