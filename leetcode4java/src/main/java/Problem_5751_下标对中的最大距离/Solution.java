package Problem_5751_下标对中的最大距离;

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int left = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums2.length - 1- i <= maxDistance) {
                return maxDistance;
            }
            for (int j = Math.max(left, i); j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]) {
                    left = j;
                    maxDistance = Math.max(maxDistance, nums2.length - 1- i - i);
                    break;
                }
            }
        }
        return maxDistance;
    }
}