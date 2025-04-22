class Solution {
    private static final int mod = (int) (1e9 + 7);

    public int countTexts(String keys) {

        int n = keys.length();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, keys, dp);
    }

    public int helper(int i, String keys, int[] dp) {
        if (i == keys.length()) {
            return 1;
        }
        if (dp[i] != -1)
            return dp[i];

        int res = 0;
        char l = keys.charAt(i);
        int maxlimit = 3;
        if (l == '7' || l == '9') {
            maxlimit = 4;
        }
        for (int j = 0; j < maxlimit; j++) {
            if (i + j < keys.length()) {
                if (keys.charAt(i + j) != l)
                    break;
                res = (res + helper(i + j + 1, keys, dp)) % mod;
            }

        }
        dp[i] = res;
        return res;
    }
}


// Total Work = O(n) calls × O(k) work per call
// ⇒ O(n × k)

// Since k is a small constant (≤ 4), we simplify it to:

// 👉 O(n) Time Complexity


// Space Complexity: O(n)