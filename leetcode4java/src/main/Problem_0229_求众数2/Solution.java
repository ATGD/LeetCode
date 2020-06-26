package Problem_0229_求众数2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer value = null;
        List<Integer> resultList = new ArrayList<>();
        int count = 0;

        for (int item : nums) {
            if (count == 0)
                value = item;
            count += (item == value ? 2 : -1);
        }
        if (count > 0)
            resultList.add(value);
        count = 0;
        for (int num : nums) {
            if (resultList.contains(num))
                continue;
            if (count == 0)
                value = num;
            if (resultList.size() > 0)
                count += (num == value ? 1 : -1);
            else
                count += (num == value ? 2 : -1);
        }
        if (count > 0)
            resultList.add(value);
        int size = resultList.size();
        Iterator<Integer> iterator = resultList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            int countNum = 0;
            for (int num : nums) {
                if (num == next)
                    countNum++;
            }
            if (countNum <= nums.length / 3) {
                iterator.remove();
            }
        }
        return resultList;
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().majorityElement(new int[]{
               6,5,5
        });
        System.out.println(integers);
    }
}
