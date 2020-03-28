package Meeting_0046_把数字翻译成字符串;

class Solution {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        if (numStr == null || numStr.isEmpty())
            return 0;
        if (String.valueOf(num).length() == 1)
            return 1;
        return recursionNum(numStr, 0);
    }

    private int recursionNum(String numStr, int position) {
        if (position == numStr.length())
            return 1;
        if (position== numStr.length()-1)
            return 1;
        Integer integer = Integer.valueOf(numStr.substring(position, position + 2));
        if (integer > 25 || numStr.charAt(position) == '0')
            return recursionNum(numStr, position + 1);
        else
            return recursionNum(numStr, position + 1) + recursionNum(numStr, position + 2);
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().translateNum(506);
        System.out.println(i);
    }
}