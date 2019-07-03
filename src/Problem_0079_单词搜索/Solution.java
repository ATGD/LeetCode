package Problem_0079_单词搜索;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word == "")
            return true;
        boolean[][] marked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] clone = new boolean[marked.length][marked[0].length];
                    for (int i1 = 0; i1 < clone.length; i1++) {
                        clone[i1] = marked[i1].clone();
                    }
                    clone[i][j] = true;
                    boolean b = hasWord(i, j, board, word, 1, clone);
                    if (b)
                        return b;
                }
            }
        }
        return false;
    }

    private boolean hasWord(int row, int col, char[][] board, String word, int indexPrepare, boolean[][] clone) {
        if (indexPrepare >= word.length())
            return true;
        if (row > 0) {
            if (board[row - 1][col] == word.charAt(indexPrepare) &&
                    clone[row - 1][col] != true) {
                boolean[][] cloneRe = new boolean[clone.length][clone[0].length];
                for (int i1 = 0; i1 < cloneRe.length; i1++) {
                    cloneRe[i1] = clone[i1].clone();
                }
                cloneRe[row - 1][col] = true;
                boolean b = hasWord(row - 1, col, board, word, indexPrepare + 1, cloneRe);
                if (b) {
                    return b;
                }
            }
        }
        if (col > 0) {
            if (board[row][col - 1] == word.charAt(indexPrepare) &&
                    clone[row][col - 1] != true) {
                boolean[][] cloneRe = new boolean[clone.length][clone[0].length];
                for (int i1 = 0; i1 < cloneRe.length; i1++) {
                    cloneRe[i1] = clone[i1].clone();
                }
                cloneRe[row][col - 1] = true;
                boolean b = hasWord(row, col - 1, board, word, indexPrepare + 1, cloneRe);
                if (b) {
                    return b;
                }
            }
        }
        if (row < board.length - 1) {
            if (board[row + 1][col] == word.charAt(indexPrepare) &&
                    clone[row + 1][col] != true) {
                boolean[][] cloneRe = new boolean[clone.length][clone[0].length];
                for (int i1 = 0; i1 < cloneRe.length; i1++) {
                    cloneRe[i1] = clone[i1].clone();
                }
                cloneRe[row + 1][col] = true;
                boolean b = hasWord(row + 1, col, board, word, indexPrepare + 1, cloneRe);
                if (b) {
                    return b;
                }
            }
        }
        if (col < board[0].length - 1) {
            if (board[row][col + 1] == word.charAt(indexPrepare) &&
                    clone[row][col + 1] != true) {
                boolean[][] cloneRe = new boolean[clone.length][clone[0].length];
                for (int i1 = 0; i1 < cloneRe.length; i1++) {
                    cloneRe[i1] = clone[i1].clone();
                }
                cloneRe[row][col + 1] = true;
                boolean b = hasWord(row, col + 1, board, word, indexPrepare + 1, cloneRe);
                if (b) {
                    return b;
                }
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        boolean asa = new Solution().exist(board, "AAB");
        System.out.println(asa);
    }
}

