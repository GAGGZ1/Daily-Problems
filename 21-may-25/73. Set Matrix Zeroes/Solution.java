class Solution {
    public void setZeroes(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        boolean firstrowzr = false;
        boolean firstcolzr = false;

        for (int i = 0; i < m; i++) {

            if (mat[i][0] == 0) {

                firstcolzr = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {

            if (mat[0][j] == 0) {

                firstrowzr = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        if (firstrowzr) {
            for (int j = 0; j < n; j++) {
                mat[0][j] = 0;
            }
        }
        if (firstcolzr) {
            for (int i = 0; i < m; i++) {
                mat[i][0] = 0;
            }
        }

    }
}