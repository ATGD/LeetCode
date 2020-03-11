package Problem_0657_机器人能否返回原点;

class Solution {
    public boolean judgeCircle(String moves) {
        int horizon = 0;
        int vertical = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'L') horizon--;
            else if (c == 'R') horizon++;
            else if (c == 'U') vertical--;
            else if (c == 'D') vertical++;
        }
        return horizon == 0 && vertical == 0;
    }
}

