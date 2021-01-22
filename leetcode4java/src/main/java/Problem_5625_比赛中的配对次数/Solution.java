package Problem_5625_比赛中的配对次数;

class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            if ((n & 1) == 1) {
                count += ((n - 1) / 2);
                n = (n - 1) / 2 + 1;
            } else {
                count += (n / 2);
                n /= 2;
            }
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numberOfMatches(7);
        System.out.println(i);
    }
}