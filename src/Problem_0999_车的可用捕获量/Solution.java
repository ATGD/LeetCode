package Problem_0999_车的可用捕获量;

class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'R') {
                    for (int L = j; L > 0; L--) {
                        if (board[i][L] == 'B')break;
                        if (board[i][L] == 'p'){
                            count++;
                            break;
                        }
                    }
                    for (int R = j; R < board[0].length; R++) {
                        if (board[i][R] == 'B')break;
                        if (board[i][R] == 'p'){
                            count++;
                            break;
                        }
                    }
                    for (int U = i; U > 0; U--) {
                        if (board[U][j] == 'B')break;
                        if (board[U][j] == 'p'){
                            count++;
                            break;
                        }
                    }
                    for (int D = i; D < board.length; D++) {
                        if (board[D][j] == 'B')break;
                        if (board[D][j] == 'p'){
                            count++;
                            break;
                        }
                    }
                }
        return count;
    }
}

