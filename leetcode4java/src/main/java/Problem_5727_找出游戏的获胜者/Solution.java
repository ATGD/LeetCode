package Problem_5727_找出游戏的获胜者;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findTheWinner(int n, int k) {
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i + 1);
        while (list.size() > 1) {
            int removeIndex = (start + (k - 1) % list.size()) % list.size();
            list.remove(removeIndex);
            start = removeIndex % list.size();
        }
        return list.get(0);
    }
}

class Test {
    public static void main(String[] args) {
        int theWinner = new Solution().findTheWinner(6, 5);
        System.out.println(theWinner);
    }
}