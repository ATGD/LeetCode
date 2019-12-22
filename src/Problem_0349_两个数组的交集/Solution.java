package Problem_0349_两个数组的交集;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> baseSet = new HashSet<>();
//        int[] longAry;
//        int[] shortAry;
//        if (nums1.length > nums2.length) {
//            longAry = nums1;
//            shortAry = nums2;
//        } else {
//            longAry = nums2;
//            shortAry = nums1;
//        }
//        for (int i : longAry)
//            baseSet.add(i);
//        Set<Integer> commonList = new HashSet<>();
//        for (int i : shortAry) {
//            if (baseSet.contains(i))
//                commonList.add(i);
//        }
//        int[] ints = new int[commonList.size()];
//        Iterator<Integer> iterator = commonList.iterator();
//        for (int i = 0; i < ints.length; i++) {
//            ints[i] = iterator.next();
//        }
//        return ints;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        set1.retainAll(set2);
        int[] ints = new int[set1.size()];
        int index = 0;
        for (Integer integer : set1) ints[index++] = integer;
        return ints;
    }
}
