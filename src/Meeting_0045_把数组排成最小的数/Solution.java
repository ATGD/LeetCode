package Meeting_0045_把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String minNumber(int[] nums) {
        String[] strnums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strnums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strnums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for(String num : strnums){
            sb.append(num);
        }
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().minNumber(new int[]{
                10, 2
        });
        System.out.println(s);
//        "1399,4398,5607,5703,6973,824,8247,938,9609"
//        "1399,4398,5607,5703,6973,8247,824,938,9609"
    }
}