class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int[] nums,int i,ArrayList<Integer>curr,List<List<Integer>>res){
        if(i==nums.length){
            res.add(curr);
            return;
        }
        //pick
        curr.add(nums[i]);
        helper(nums,i+1,curr,res);

        //backtrack
        curr.remove(curr.size()-1);

        //not pick
        helper(nums,i+1,curr,res);

    }

}