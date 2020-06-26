package Problem_5352_生成每种字符都是奇数个的字符串;

class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if ((n & 1) == 1) {
            for (int i = 0; i < n; i++) sb.append('a');
        } else {
            for (int i = 0; i < n-1; i++) sb.append('a');
            sb.append('b');
        }
        return sb.toString();
    }
}

class Test{
    public static void main(String[] args) {
        String s = new Solution().generateTheString(2);
        System.out.println(s);
    }
}