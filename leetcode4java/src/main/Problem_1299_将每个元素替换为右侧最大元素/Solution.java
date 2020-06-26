package Problem_1299_将每个元素替换为右侧最大元素;

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        int[] maxs = new int[arr.length];
        maxs[maxs.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            max = Math.max(arr[i + 1], max);
            maxs[i] = max;
        }
        return maxs;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().replaceElements(new int[]{
                7, 6,100, 4, 3, 2, 1
        });
        System.out.println(ints);
    }
}
