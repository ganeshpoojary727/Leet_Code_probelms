class Solution {

    public int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] arr = new int[rows * cols];

        int index = 0;
        int diagonal = 0;

        // Start from top row
        for (int col = 0; col < cols; col++) {
            index = DiagonalElements(mat, arr, 0, col, diagonal, index);
            diagonal++;
        }

        // Start from rightmost column
        for (int row = 1; row < rows; row++) {
            index = DiagonalElements(mat, arr, row, cols - 1, diagonal, index);
            diagonal++;
        }

        return arr;
    }

    public int DiagonalElements(
        int[][] mat,
        int[] arr,
        int row,
        int col,
        int diagonal,
        int index
    ) {

        int[] temp = new int[Math.min(mat.length, mat[0].length)];
        int count = 0;

        // Traverse down-left
        while (row < mat.length && col >= 0) {

            temp[count] = mat[row][col];
            count++;

            row++;
            col--;
        }

        // EVEN → reverse
        if (diagonal % 2 == 0) {

            for (int i = count - 1; i >= 0; i--) {
                arr[index++] = temp[i];
            }

        }
        // ODD → normal
        else {

            for (int i = 0; i < count; i++) {
                arr[index++] = temp[i];
            }
        }

        return index;
    }
}