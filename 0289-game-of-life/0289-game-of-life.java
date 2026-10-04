class Solution {
    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[][] arr = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                isalive(board, arr, row, col);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = arr[row][col];
            }
        }
    }

    public void isalive(int[][] board, int[][] arr, int row, int col) {

        int rows = board.length;
        int cols = board[0].length;

        int count = 0;

        if (row - 1 >= 0 && col - 1 >= 0 &&
            board[row - 1][col - 1] == 1) {
            count++;
        }

        if (row - 1 >= 0 &&
            board[row - 1][col] == 1) {
            count++;
        }

        if (row - 1 >= 0 && col + 1 < cols &&
            board[row - 1][col + 1] == 1) {
            count++;
        }

        if (col - 1 >= 0 &&
            board[row][col - 1] == 1) {
            count++;
        }

        if (col + 1 < cols &&
            board[row][col + 1] == 1) {
            count++;
        }

        if (row + 1 < rows && col - 1 >= 0 &&
            board[row + 1][col - 1] == 1) {
            count++;
        }

        if (row + 1 < rows &&
            board[row + 1][col] == 1) {
            count++;
        }

        if (row + 1 < rows && col + 1 < cols &&
            board[row + 1][col + 1] == 1) {
            count++;
        }

        // Apply Game of Life rules
        if (board[row][col] == 1) {

            if (count == 2 || count == 3) {
                arr[row][col] = 1;
            } else {
                arr[row][col] = 0;
            }

        } else {

            if (count == 3) {
                arr[row][col] = 1;
            } else {
                arr[row][col] = 0;
            }
        }
    }
}