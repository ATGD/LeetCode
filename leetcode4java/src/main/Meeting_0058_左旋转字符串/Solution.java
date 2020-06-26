package Meeting_0058_左旋转字符串;

class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

class Test{
    public static void main(String[] args) {
        String s = new Solution().reverseLeftWords("abc", 1);
        System.out.println(s);
    }
}