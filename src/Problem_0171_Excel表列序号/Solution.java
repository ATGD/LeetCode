package Problem_0171_Excel表列序号;


class Solution {
    public int titleToNumber(String s) {
        int accum = 0;
        for (int i = 0; i < s.length(); i++) {
            accum = accum * 26 + s.charAt(i) - 'A'+1;
        }
        return accum;
    }
}


class Test {
    public static void main(String[] args) {
        int result = new Solution().titleToNumber("ZY");
        System.out.println(result);
    }
}
