package Problem_0665_非递减数列;

class Solution {
    public boolean checkPossibility(int[] nums) {
        int[] compare = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int errorCount = 0;
        for (int num : nums) {
            if (num < compare[1]) {
                if (++errorCount > 1) return false;
                if (num < compare[0]) compare[0] = compare[1];
                else compare[0] = compare[1] = num;
            } else {
                compare[0] = compare[1];
                compare[1] = num;
            }
        }
        return true;
    }
}
