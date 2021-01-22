package Problem_5473_灯泡开关4;

class Solution {
    public int minFlips(String target) {
        char[] chars = target.toCharArray();
        int flag = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' == flag) continue;
            flag = 1 - flag;
            count++;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minFlips("001011101");
        System.out.println(i);
    }
}