package Problem_0303_区域和检索_数组不可变;

class NumArray {
    int[] numsCount;

    public NumArray(int[] nums) {
        numsCount = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            numsCount[i] = temp += nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >= numsCount.length) throw new UnsupportedOperationException("i is out of range");
        if (j < 0 || j >= numsCount.length) throw new UnsupportedOperationException("j is out of range");
        if (i == 0) return numsCount[j];
        return numsCount[j] - numsCount[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

class Test {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6});
        int i = numArray.sumRange(1, 3);
        System.out.println(i);
    }
}

