package Problem_5759_找出所有子集的异或总和再求和;

class Solution {

    int sum = 0;
    int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        dfs( 0, 0);
        return sum;
    }

    private void dfs(int index, int res) {
        if (index == nums.length) {
            sum += res;
            return;
        }
        dfs(index+1,res);
        dfs(index+1,res ^ nums[index]);
    }
}