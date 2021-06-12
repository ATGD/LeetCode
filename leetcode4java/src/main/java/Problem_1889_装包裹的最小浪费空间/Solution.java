package Problem_1889_装包裹的最小浪费空间;

import java.util.Arrays;

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {

        long min = -1;
        int mod = 1000000007;

        for (int[] box : boxes) Arrays.sort(box);

        for (int[] boxAry : boxes) {
            long tmpSum = 0;
            int indexInPackages = 0;
            int indexInBox = 0;

            int lastIndexInPackages = -1;

            boolean canHold = true;
            while (indexInPackages < packages.length && indexInBox < boxAry.length) {
                int indexInPackagesTmp = binarySearch(boxAry[indexInBox], indexInPackages, packages.length - 1, packages);
                if (indexInPackagesTmp == -1) {
                    if (indexInBox == boxAry.length - 1) {
                        canHold = false;
                        break;
                    } else {
                        indexInBox++;
                    }
                } else {
                    for (int i = lastIndexInPackages + 1; i <= indexInPackagesTmp; i++) {
                        tmpSum += (boxAry[indexInBox] - packages[i]);
                    }
                    lastIndexInPackages = indexInPackagesTmp;
                    indexInPackages = lastIndexInPackages + 1;
                    if (indexInPackagesTmp == packages.length - 1) {
                        break;
                    }
                }
            }
            if (canHold && (lastIndexInPackages == packages.length - 1)) {
                min = ((min == -1) ? tmpSum : Math.min(min, tmpSum));
            }
        }
        return (int) (min % mod);
    }

    private int binarySearch(int value, int start, int end, int[] ary) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (ary[mid] == value)
                return mid;

            if (ary[mid] < value)
                start = mid + 1;
            else
                end = mid;
        }
        if (ary[start] < value) {
            return -1;
        }
        return start;
    }
}