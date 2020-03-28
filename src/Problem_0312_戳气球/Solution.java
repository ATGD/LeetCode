package Problem_0312_戳气球;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) list.add(num);
        int coins = 0;
        while (list.size() > 0) {
            int breakIndex = getBreakIndex(list);
            int coinsAdd = 0;
            if (list.size() == 1) {
                coinsAdd = list.get(0) + 1 + 1;
                coins += coinsAdd;
            } else {
                if (breakIndex == 0) {
                    coinsAdd = (list.get(breakIndex) + list.get(breakIndex + 1)) + 1;
                    coins += coinsAdd;
                } else if (breakIndex == list.size() - 1) {
                    coinsAdd = (list.get(breakIndex) + list.get(breakIndex - 1) + 1);
                    coins += coinsAdd;
                } else {
                    coinsAdd = (list.get(breakIndex) + list.get(breakIndex - 1) + list.get(breakIndex + 1));
                    coins += coinsAdd;
                }
            }
            System.out.println("coinsAdd:" + coinsAdd + "个");
            list.remove(breakIndex);
        }
        return coins;
    }

    private int getBreakIndex(List<Integer> nums) {
        int[] canGet = new int[nums.size()];
        for (int i = 0; i < canGet.length; i++) {
            if (i == 0 && nums.size() == 1)
                return 0;
            else if (i == 0)
                canGet[i] = nums.get(i + 1) + 1 + nums.get(i);
            else if (i == nums.size() - 1)
                canGet[i] = nums.get(i - 1) + 1 + nums.get(i);
            else
                canGet[i] = nums.get(i - 1) + nums.get(i + 1) + nums.get(i);
        }
        int index = 0;
        int value = canGet[0];
        for (int i = 1; i < canGet.length; i++) {
            if (value > canGet[i]) {
                value = canGet[i];
                index = i;
            }
        }
        return index;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().maxCoins(new int[]{

        });
        System.out.println(i);
        //()(())())(()(()()()()(()(())()(()()()
    }
}

