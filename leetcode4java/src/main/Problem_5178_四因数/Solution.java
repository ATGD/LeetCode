package Problem_5178_四因数;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> con = countDivisors(nums[i]);
            if (con != null) for (int value : con) count += value;
        }
        return count;
    }

    private Set<Integer> countDivisors(int num) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (set.size() > 4) return null;
                set.add(i);
                set.add(num / i);
            }
        }
        if (set.size() == 4) return set;
        else return null;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().sumFourDivisors(new int[]{
                21, 5, 7
        });
        System.out.println(i);
    }
}