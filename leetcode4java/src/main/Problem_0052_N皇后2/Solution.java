package Problem_0052_N皇后2;


class Solution {

    private int N;
    private int[] rcSumSet;//行和列的差
    private int[] rcDisSet;//行和列的和
    private int[] cAppearSet;//出现的列
    private int count;

    public int totalNQueens(int n) {
        if (n == 0) return 0;
        this.N = n;
        rcSumSet = new int[2 * N - 1];
        rcDisSet = new int[2 * N - 1];
        cAppearSet = new int[N];
        //开始回溯
        backtraceRow(0);
        return count;
    }

    private void backtraceRow(int row) {
        if (row == N) return;
        for (int column = 0; column < N; column++) {
            boolean canInsert = checkSet(row, column);
            if (canInsert) {
                putOrRemoveSetElement(row, column, true);
                if (row + 1 == N) count++;
                else backtraceRow(row + 1);
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
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().totalNQueens(5);
        System.out.println(i);
    }
}
