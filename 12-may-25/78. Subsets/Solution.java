class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        solve(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void solve(int []nums,int s,List<Integer>curr,List<List<Integer>>res){
        res.add(new ArrayList<>(curr));

        for(int i=s;i<nums.length;i++){
            curr.add(nums[i]);
            solve(nums,i+1,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}