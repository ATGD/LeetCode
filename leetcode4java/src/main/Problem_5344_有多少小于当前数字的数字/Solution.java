package Problem_5344_有多少小于当前数字的数字;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[j] < nums[i]) result[i]++;
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().smallerNumbersThanCurrent(new int[]{

        });
        System.out.println(ints);
    }
}