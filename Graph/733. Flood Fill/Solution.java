class Solution {

    private static final int[][] DIR = {
        {-1, 0}, // up
        {1, 0},  // down
        {0, -1}, // left
        {0, 1}   // right
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // Nothing to change
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col,
                     int originalColor, int newColor) {

        // Change current cell
        image[row][col] = newColor;

        // Explore 4 directions
        for (int[] direction : DIR) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check boundaries
            if (newRow < 0 || newRow >= image.length ||
                newCol < 0 || newCol >= image[0].length) {
                continue;
            }

            // Only visit cells having the original color
            if (image[newRow][newCol] == originalColor) {
                dfs(image, newRow, newCol, originalColor, newColor);
            }
        }
    }
}