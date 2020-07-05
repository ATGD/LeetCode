package Problem_0566_重塑矩阵;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) return nums;
        int row = nums.length;
        int column = nums[0].length;
        int total = row * column;
        if (total != r * c || total == 0) return nums;
        int[][] results = new int[r][c];
        for (int start = 0; start < total; start++)
            results[start / c][start % c] = nums[start / column][start % column];
        return results;
    }
}