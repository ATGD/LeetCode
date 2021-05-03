package test.sort;

public class QuickSort {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int base = nums[left];
            while (i < j) {
                while (i < j && nums[j] >= base) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] <= base) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = base;
            sort(nums, left, i - 1);
            sort(nums, i + 1, right);
        }
    }
}

class Test {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {
                0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1
        };
        quickSort.quickSort(nums);
        System.out.println(nums);
    }
}
