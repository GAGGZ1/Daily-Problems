public class Solution {
  
}
class Solution {
    String ans = "";
    int count = 0;

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        solve(n, k, new StringBuilder(), used);
        return ans;
    }

    public void solve(int n, int k, StringBuilder curr, boolean[] used) {
        if (curr.length() == n) {
            count++;
            if (count == k) {
                ans = curr.toString();

            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.append(i);
                solve(n, k, curr, used);
                curr.setLength(curr.length() - 1);
                used[i] = false;

                if (!ans.equals(""))
                    return;
            }
        }
    }
}