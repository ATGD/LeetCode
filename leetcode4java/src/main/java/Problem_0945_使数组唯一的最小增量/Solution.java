package Problem_0945_使数组唯一的最小增量;

class Solution {
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        int[] bucket = new int[80002];
        for (int i : A) bucket[i]++;
        int tmpIndex = 0;
        int inputIndex = 0;
        while (tmpIndex < bucket.length) {
            if (bucket[tmpIndex] > 1) {
                inputIndex = Math.max(inputIndex, tmpIndex + 1);
                while (bucket[tmpIndex] > 1) {
                    while (bucket[inputIndex] != 0) inputIndex++;
                    count += (inputIndex - tmpIndex);
                    bucket[inputIndex++] = 1;
                    bucket[tmpIndex]--;
                }
            }

            tmpIndex++;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minIncrementForUnique(new int[]{
                14, 4, 5, 14, 13, 14, 10, 17, 2, 12, 2, 14, 7, 13, 14, 13, 4, 16, 4, 10
        });
        System.out.println(i);
    }
}