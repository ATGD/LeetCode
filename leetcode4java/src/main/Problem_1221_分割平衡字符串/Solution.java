package Problem_1221_分割平衡字符串;

class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int status = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') status++;
            else if (c == 'R') status--;
            if (status == 0) count++;
        }
        return count;
    }
}

class Test {
    public static void main(String[] args) {
    }
}

