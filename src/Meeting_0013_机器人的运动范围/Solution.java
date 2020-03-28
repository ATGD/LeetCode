package Meeting_0013_机器人的运动范围;

class Solution {

    int[][] around = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] path;

    public boolean exist(char[][] board, String word) {
        path = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == word.charAt(0)
                        && recursionPath(board, i, j, word.toCharArray(), 0))
                    return true;
        return false;
    }

    private boolean recursionPath(char[][] board, int row, int column, char[] word, int start) {
        if (start >= word.length) return true;
        if (row < 0
                || column < 0
                || row >= board.length
                || column >= board[row].length
                || path[row][column] == 1
                || board[row][column] != word[start]
        ) return false;
        boolean result = false;
        path[row][column] = 1;
        for (int[] offset : around) {
            result |= recursionPath(board, row + offset[0], column + offset[1], word, start + 1);
            if (result == true)
                return true;
        }
        path[row][column] = 0;
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        boolean result = new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        }, "ABCCED");
    }
}