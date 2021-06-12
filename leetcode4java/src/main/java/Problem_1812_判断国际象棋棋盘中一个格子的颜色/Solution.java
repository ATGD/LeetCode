package Problem_1812_判断国际象棋棋盘中一个格子的颜色;

class Solution {
    public boolean squareIsWhite(String coordinates) {
        char column = coordinates.charAt(0);
        char row = coordinates.charAt(1);
        boolean isWhiteFirst = ((column - 'a') & 1) == 1;
        boolean isSame = ((row - '1') & 1) != 1;
        return !isWhiteFirst ^ isSame;
    }
}