package Problem_5773_插入后的最大值;

class Solution {
    public String maxValue(String n, int x) {
        boolean isUnderZero = n.startsWith("-");
        int start = isUnderZero ? 1 : 0;
        while (start < n.length()) {
            if (!isUnderZero && n.charAt(start) < (x + '0')) break;
            if (isUnderZero && n.charAt(start) > (x + '0')) break;
            start++;
        }
        return new StringBuilder(n).insert(start, x).toString();
    }
}

class Test{
    public static void main(String[] args) {
        String s = new Solution().maxValue("553300664422", 7);
        System.out.println(s);
    }
}