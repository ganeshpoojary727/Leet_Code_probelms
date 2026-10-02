class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    public void dfs(int[][] image, int row, int col,
                    int originalColor, int color) {

        // Out of bounds OR different color
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length ||
            image[row][col] != originalColor) {

            return;
        }

        // Change current cell
        image[row][col] = color;

        // Visit neighbors
        dfs(image, row - 1, col, originalColor, color); // up
        dfs(image, row + 1, col, originalColor, color); // down
        dfs(image, row, col - 1, originalColor, color); // left
        dfs(image, row, col + 1, originalColor, color); // right
    }
}