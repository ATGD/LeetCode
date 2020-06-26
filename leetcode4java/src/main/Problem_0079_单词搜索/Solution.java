package Problem_0079_单词搜索;

class Solution {
    int[][] directs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] hasWalk;

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        if (null == word || word.length() == 0) return false;
        hasWalk = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == words[0]) {
                    boolean result = hasContains(board, row, column, word, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private boolean hasContains(char[][] board, int row, int column, String word, int wordIndex) {
        if (wordIndex >= word.length()) return true;
        if (!isInRange(board, row, column) || board[row][column] != word.charAt(wordIndex)) return false;
        if (hasWalk[row][column]) return false;
        for (int[] direct : directs) {
            hasWalk[row][column] = true;
            boolean result = hasContains(board, row + direct[0], column + direct[1], word, wordIndex + 1);
            if (result) return true;
            hasWalk[row][column] = false;
        }
        return false;
    }

    private boolean isInRange(char[][] board, int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }
}

class Test {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C'},
                {'A','B','C'},
                {'A','B','C'},
        };
        boolean asa = new Solution().exist(board, "ABCCBA");
        System.out.println(asa);
    }
}

