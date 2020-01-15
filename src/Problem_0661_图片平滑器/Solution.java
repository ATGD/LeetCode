package Problem_0661_图片平滑器;

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int width = M[0].length;
        int height = M.length;
        int[] range = {-1, 0, 1};
        int[][] N = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int sum = 0;
                int count = 0;
                for (int yAdd : range) {
                    for (int xAdd : range) {
                        int yAxis = i + yAdd;
                        int xAxis = j + xAdd;
                        if (yAxis >= 0 && yAxis < height && xAxis >= 0 && xAxis < width) {
                            sum += M[yAxis][xAxis];
                            count++;
                        }
                    }
                }
                N[i][j] = sum / count;
            }
        }
        return N;
    }
}

