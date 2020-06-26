package Problem_0289_生命游戏;

class Solution {

    int[][] around = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                boardCopy[i][j] = calcAlive(i, j, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) board[i][j] = boardCopy[i][j];
        }
    }

    private int calcAlive(int i, int j, int[][] board) {
        int aliveCount = 0;
        for (int[] ints : around) {
            if (isInRange(ints[0] + i, ints[1] + j, board)) {
                if (board[ints[0] + i][ints[1] + j] == 1) {
                    aliveCount++;
                }
            }
        }
        if (board[i][j] == 0 && aliveCount == 3) return 1;
        if (board[i][j] == 1 && (aliveCount > 3 || aliveCount < 2)) return 0;
        return board[i][j];
    }

    private boolean isInRange(int i, int j, int[][] board) {
        if (i < 0) return false;
        if (i >= board.length) return false;
        if (j < 0) return false;
        if (j >= board[0].length) return false;
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][]{
                {0, 0}
        });
    }
}
