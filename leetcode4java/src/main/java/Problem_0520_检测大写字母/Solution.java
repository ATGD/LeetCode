package Problem_0520_检测大写字母;

class Solution {
    public boolean detectCapitalUse(String word) {
        int state = -1;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                switch (state) {
                    case -1:
                        state = 1;
                        break;
                    case 0:
                        return false;
                    default:
                        state = 2;
                }
            } else {
                if (state <= 1) {
                    state = 0;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

class Test {
    //0,1,1,2,3,5,8
    public static void main(String[] args) {
        boolean abc = new Solution().detectCapitalUse("abBc");
        System.out.println(abc);
    }
}

