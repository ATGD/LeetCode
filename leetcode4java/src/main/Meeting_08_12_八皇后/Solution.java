package Meeting_08_12_八皇后;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private char[][] pos;
    private int N;
    int[] rcSumSet;//行和列的差
    int[] rcDisSet;//行和列的和
    int[] cAppearSet;//出现的列
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return result;
        pos = new char[n][n];
        this.N = n;
        rcSumSet = new int[2 * N - 1];
        rcDisSet = new int[2 * N - 1];
        cAppearSet = new int[N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) pos[i][j] = '.';
        //开始回溯
        backtraceRow(0);
        return result;
    }

    private void backtraceRow(int row) {
        if (row == N) return;
        for (int column = 0; column < N; column++) {
            boolean canInsert = checkSet(row, column);
            if (canInsert) {
                putOrRemoveSetElement(row, column, true);
                pos[row][column] = 'Q';
                if (row + 1 == N) {
                    List<String> itemResult = new ArrayList<>();
                    for (int i = 0; i < N; i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < N; j++) sb.append(pos[i][j]);
                        itemResult.add(sb.toString());
                    }
                    result.add(itemResult);
                } else {
                    backtraceRow(row + 1);
                }
                pos[row][column] = '.';//恢复数组
                putOrRemoveSetElement(row, column, false);
            }
        }
    }

    private boolean checkSet(int row, int column) {
        if (cAppearSet[column] == 1) return false;
        else if (rcSumSet[row + column] == 1) return false;
        else if (rcDisSet[N - 1 - row + column] == 1) return false;
        else return true;
    }

    private void putOrRemoveSetElement(int row, int column, boolean isPut) {
        if (isPut) {
            cAppearSet[column] = 1;
            rcSumSet[row + column] = 1;
            rcDisSet[N - 1 - row + column] = 1;
        } else {
            cAppearSet[column] = 0;
            rcSumSet[row + column] = 0;
            rcDisSet[N - 1 - row + column] = 0;
        }
    }

//    private boolean canInsert(int row, int column, int N, int rowPlus, int columnPlus) {
//        while (row >= 0 & row < N & column >= 0 & column < N) {
//            if (pos[row][column] == 'Q') return false;
//            row += rowPlus;
//            column += columnPlus;
//        }
//        return true;
//    }
}

class Test {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(5);
        System.out.println(lists);
    }
}