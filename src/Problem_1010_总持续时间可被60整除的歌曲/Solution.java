package Problem_1010_总持续时间可被60整除的歌曲;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numPairsDivisibleBy60(new int[]{60, 30, 150, 180, 90, 120});
        System.out.println(i);
    }
}

