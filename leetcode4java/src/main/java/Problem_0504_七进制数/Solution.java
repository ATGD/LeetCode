package Problem_0504_七进制数;


class Solution {
    public String convertToBase7(int num) {
        boolean isFu = false;
        if (num < 0) {
            isFu = true;
        }
        StringBuffer str = new StringBuffer();
        do {
            str.insert(0, Math.abs(num % 7));
            num /= 7;
        } while (num != 0);
        return (isFu ? "-" : "") + str.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().convertToBase7(-100);
        System.out.println(s);
    }
}