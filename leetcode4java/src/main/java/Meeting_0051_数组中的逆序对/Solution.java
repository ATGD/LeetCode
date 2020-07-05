package Meeting_0051_数组中的逆序对;

class Solution {

    private int cnt = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if (end != start) {
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            int[] mergeNums = new int[end - start + 1];
            int left = start;
            int right = mid + 1;
            int tmpIndex = 0;
            while (left <= mid || right <= end) {
                if (left > mid) {
                    mergeNums[tmpIndex++] = nums[right++];
                } else if (right > end) {
                    mergeNums[tmpIndex++] = nums[left++];
                } else if (nums[left] <= nums[right]) {
                    mergeNums[tmpIndex++] = nums[left++];
                } else {
                    cnt += (mid - left + 1);
                    mergeNums[tmpIndex++] = nums[right++];
                }
            }
            System.arraycopy(mergeNums, 0, nums, start, mergeNums.length);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().reversePairs(new int[]{

        });
        System.out.println(i);
    }
}