package Problem_5400_旅行终点站;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String destCity(List<List<String>> paths) {
        boolean[] alreadyGone = new boolean[paths.size()];
        int tmpIndex = 0;
        while (true) {
            List<String> tmpList = paths.get(tmpIndex);
            String tmpStr = tmpList.get(tmpList.size() - 1);
            boolean hasFind = false;
            for (int i = 0; i < alreadyGone.length; i++) {
                boolean gone = alreadyGone[i];
                if (gone) continue;
                if (i == tmpIndex) continue;
                if (paths.get(i).get(0).equals(tmpStr)) {
                    tmpIndex = i;
                    hasFind = true;
                    break;
                }
                alreadyGone[tmpIndex] = true;
            }
            if (!hasFind) {
                return tmpStr;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("London", "New York"));
        List<String> list2 = new ArrayList<>(Arrays.asList("New York", "Lima"));
        List<String> list3 = new ArrayList<>(Arrays.asList("Lima", "Sao Paulo"));
        paths.add(list1);
        paths.add(list2);
        paths.add(list3);
        String s = new Solution().destCity(paths);
        System.out.println(s);
    }
}