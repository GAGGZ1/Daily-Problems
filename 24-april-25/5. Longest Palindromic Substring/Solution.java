class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        int dp[][] = new int[n][n];

        for (int d[] : dp) {

            Arrays.fill(d, -1);

        }

        for (int i = 0; i < n; i++) {

            dp[i][i] = 1;

        }

        for (int i = 0; i < n - 1; i++) {

            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 1 : 0;

        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {

                int j = i + len - 1;

                if (dp[i][j] == -1) {

                    if (s.charAt(i) == s.charAt(j))

                        dp[i][j] = dp[i + 1][j - 1];

                    else {

                        dp[i][j] = 0;

                    }

                }

            }

        }

        int max = 0;
        int st = 0;
        int ed = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 1) {

                    if (max < j - i + 1) {

                        max = j - i + 1;

                        st = i;

                        ed = j;

                    }

                }

            }

        }

        return s.substring(st, ed + 1);

    }

}


// Time Complexity	O(n²)
// Space Complexity	O(n²)