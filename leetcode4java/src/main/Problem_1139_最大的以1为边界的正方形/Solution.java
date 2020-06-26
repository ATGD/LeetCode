package Problem_1139_最大的以1为边界的正方形;

class Solution {

    public int largest1BorderedSquare(int[][] grid) {
        int maxLength = 0;
        int maxCount = 0;
        for (int i = 0; i < grid.length; i++) {
            int nowStart = -1;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    nowStart = -1;
                } else {
                    if (nowStart == -1) {
                        maxLength = 1;
                        maxCount = 1;
                        nowStart = j;
                        continue;
                    }
                    if (nowStart == -2) {
                        nowStart = -1;
                        continue;
                    }
                    if ((nowStart != -1 && (j - nowStart < maxLength)) ||
                            (j - nowStart > grid.length - 1 - i)
                    ) {
                        continue;
                    }
                    boolean isTrueSquare = true;
                    for (int k = nowStart; k <= j; k++) {
                        if (grid[i + j - nowStart][k] != 1) {
                            nowStart = -1;
                            isTrueSquare = false;
                            break;
                        }
                    }
                    if (isTrueSquare) {
                        for (int k = i; k <= i + j - nowStart; k++) {
                            if (grid[k][nowStart] != 1) {
                                isTrueSquare = false;
                                nowStart = -2;
                                break;
                            }
                        }
                    }

                }
            }
        }
        return maxCount;
    }
}

class Test {
    public static void main(String[] args) {

    }
}

