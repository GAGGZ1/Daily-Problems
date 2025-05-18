
public class Solution {

  public class Checksort implements Comparable<Checksort> {
    int v;

    public Checksort(int v) {
      this.v = v;
    }

    public int digitSum(int n) {
      int sum = 0;
      while (n > 0) {
        sum += n % 10;
        n = n / 10;
      }
      return sum;
    }

    @Override
    public int compareTo(Checksort other) {
      int thisSum = digitSum(this.v);
      int otherSum = digitSum(other.v);
      if (thisSum != otherSum) {
        return Integer.compare(thisSum, otherSum);
      } else {
        return Integer.compare(this.v, other.v);
      }
    }
  }

  public int minSwaps(int[] nums) {

        int n = nums.length;
        List<Checksort> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new Checksort(num));
        }

        Collections.sort(list);

        int[] temp = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i).v;
        }

        System.out.println(Arrays.toString(temp));

        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(nums[i], i);
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (temp[i] != nums[i]) {
                int ind = pos.get(temp[i]);
                int tempvalue = nums[i];
                nums[i] = nums[ind];
                nums[ind] = tempvalue;
                pos.put(nums[i], ind);
                swaps++;
            }
        }
        return swaps;
    }

}©leetcode