package Problem_1588_所有奇数长度子数组的和;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftSingle = (i + 1) / 2;
            int rightSingle = (arr.length - i) / 2;
            int leftDouble = (i + 2) / 2;
            int rightDouble = (arr.length - i + 1) / 2;
            count += (leftSingle * rightSingle * arr[i]);
            count += (leftDouble * rightDouble * arr[i]);
        }
        return count;
    }
}

class Test{
    public static void main(String[] args) {
        int i = new Solution().sumOddLengthSubarrays(new int[]{
                10, 11, 12
        });
        System.out.println(i);
    }
}