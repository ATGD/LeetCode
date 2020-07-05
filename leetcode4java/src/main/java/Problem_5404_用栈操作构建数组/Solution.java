package Problem_5404_用栈操作构建数组;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int tmp = 1;
        int ptrTarget = 0;
        List<String> result = new ArrayList<>();
        if (target.length == 0)
            return result;
        while (ptrTarget < target.length) {
            while (tmp < target[ptrTarget]) {
                result.add("Push");
                result.add("Pop");
                tmp++;
            }
            result.add("Push");
            ptrTarget++;
            tmp++;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        List<String> result = new Solution().buildArray(new int[]{
                2,3,4
        }, 4);
        System.out.println(result);
    }
}