package Problem_5336_上升下降字符串;

class Solution {
    public String sortString(String s) {
        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder();
        boolean isDiscream = false;//刚开始从0开始
        for (int i = 0; i < s.length(); i++) alpha[s.charAt(i) - 'a']++;
        while (sb.length() < s.length()) {
            int index = isDiscream ? 25 : 0;
            while (isDiscream ? (index >= 0) : (index < 26)) {
                if (alpha[index] == 0) {
                    if (isDiscream) index--;
                    else index++;
                } else {
                    sb.append((char) (index + 'a'));
                    alpha[index]--;
                    index = isDiscream ? index - 1 : index + 1;
                }
            }
            isDiscream = !isDiscream;
        }
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().sortString("spo");
        System.out.println(s);
    }
}