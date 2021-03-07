package Problem_5698_构成特定和需要添加的最少元素;

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long total = 0;
        for (int num : nums) total += num;
        long offset = Math.abs(goal - total);
        long count = offset / limit;
        if (count * limit < offset) {
            count++;
        }
        return (int) count;
    }
}