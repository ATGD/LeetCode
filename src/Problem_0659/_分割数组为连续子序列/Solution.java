package Problem_0659._分割数组为连续子序列;

import java.util.*;

//class Solution {
//    public boolean isPossible(int[] nums) {
//        LinkedList<Integer> numList = new LinkedList<>();
//        Set<List<Integer>> pairList = new HashSet<>();
//        List<Integer> beiTai = new ArrayList<>();
//        for (int num : nums) {
//            numList.add(num);
//        }
//        LinkedList<Integer> threeList = new LinkedList<>();
//        while (numList.size() > 0) {
//            int indexShouldPeek = 0;
//            while (!numList.isEmpty() && threeList.get(indexShouldPeek) - threeList.getLast() <= 1 && indexShouldPeek < numList.size()) {
//                if (threeList.get(indexShouldPeek) - threeList.getLast() == 0) {
//                    indexShouldPeek++;
//                } else {
//                    break;
//                }
//            }
//            Integer integer = numList.get(indexShouldPeek);
//            if (threeList.size() == 0 ||
//                    ((integer - threeList.get(threeList.size() - 1)) == 1)) {
//                threeList.add(integer);
//                if (threeList.size() == 3) {
//                    pairList.add(new ArrayList<>(threeList));
//                    threeList.clear();
//                }
//            } else if ((integer - threeList.get(threeList.size() - 1)) > 1) {
//                beiTai.add(integer);
//            }
//        }
//    }
//}
//
//class Test {
//
//    public static void main(String[] args) {
//        boolean possible = new Solution().isPossible(new int[]{1, 2, 3, 5});
//        System.out.println(possible);
//    }
//}

