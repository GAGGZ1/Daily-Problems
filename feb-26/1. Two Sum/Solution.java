public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int curr = target - nums[i];
            if (map.containsKey(curr)) {
                return new int[] { map.get(curr), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
} {
  
}
