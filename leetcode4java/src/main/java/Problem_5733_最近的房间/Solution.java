package Problem_5733_最近的房间;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /*public int[] closestRoom(int[][] rooms, int[][] queries) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            int[] room = rooms[i];
            list.add(room);
        }
        Collections.sort(list, (t1, t2) -> t1[0] - t2[0]);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int preferId = queries[i][0];
            int s = queries[i][1];
            int position = binarySearch(list,preferId);
            if (list.get(position)[1] >=s)
                res[i] = list.get(position)[0];
            else{
                int left = position - 1;
                int right = position + 1;
                int leftId = left >= 0 ? list.get(left)[0] : -1;
                int rightId = right < list.size()? list.get(right)[0] : -1;
                boolean isFind = false;
                while (left >= 0 || right < list.size()) {
                    if (leftId == -1) {
                        if (list.get(right)[1] >= s) {
                            res[i] = list.get(right)[0];
                            isFind = true;
                            break;
                        } else {
                            right++;
                            rightId = right < list.size()? list.get(right)[0] : -1;
                        }
                    } else if (rightId == -1) {
                        if (list.get(left)[1] >= s) {
                            res[i] = list.get(left)[0];
                            isFind = true;
                            break;
                        } else {
                            left--;
                            leftId = left >= 0 ? list.get(left)[0] : -1;
                        }
                    } else {
                        int sLeft = list.get(left)[1];
                        int idLeft = list.get(left)[0];
                        int sRight = list.get(right)[1];
                        int idRight = list.get(right)[0];
                        int mm = 2*preferId - sLeft - sRight;
                        if (sLeft >= s && sRight >= s) {
                            if (mm<=0) {
                                res[i] = idLeft;
                            } else {
                                res[i] = idRight;
                            }
                            isFind = true;
                            break;
                        } else if (sLeft >= s) {
                            res[i] = idLeft;
                            isFind = true;
                            break;
                        } else if (sRight >= s) {
                            res[i] = idRight;
                            isFind = true;
                            break;
                        } else {
                            if (mm < 0) {
                                left--;
                            }
                        }
                    }
                }
            }
        }
        retunr
    }

    private int binarySearch(List<int[]> list, int preferId) {
        int start = 0;
        int end = list.size() - 1;
        if (preferId >= list.get(end)[0])
            return end;
        if (preferId <= list.get(start)[0])
            return start;
        while (start < end) {
            int mid = (end - start)/2 + start;
            if (list.get(mid)[0] == preferId) return mid;
            if (list.get(mid)[0] > preferId) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }*/
}