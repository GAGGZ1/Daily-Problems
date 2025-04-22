class Solution {
    public String convert(String s, int numRows) {
        int i = 0;
        int j = 0;
        int r = numRows;
        if (r == 1)
            return s;
        int c = s.length();
        char[][] mat = new char[r][c];
        for (char[] ch : mat) {
            Arrays.fill(ch, '1');
        }
        int idx = 0;
        boolean flag = false;
        while (idx < c) {
            mat[i][j] = s.charAt(idx++);

            if (!flag) {
                i++;
                if (i == r) {
                    i = r - 2;
                    j++;
                    flag = true;

                }
            } else {
                i--;
                j++;
                if (i == -1) {
                    i = 1;
                    flag = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (mat[i][j] != '1') {
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }
}