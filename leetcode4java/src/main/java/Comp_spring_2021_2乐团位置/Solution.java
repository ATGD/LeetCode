package Comp_spring_2021_2乐团位置;

class Solution {


    public int orchestraLayout(int num, int xPos, int yPos) {
        if (num == 1) return 1;
        int circle = Math.min(
                Math.min(num - 1 - xPos, xPos),
                Math.min(num - 1 - yPos, yPos)
        );
        int p = ((num - 2) * 4 + 4 + (num - 2 - circle * 2) * 4 + 4) * circle / 2;
        int tmpCilr = 0;
        long tmpCircleCount = 4 + (num - 2) * 4L;
        long tmpCircleR = num;

        long yue = 1;

        while (tmpCilr < circle) {
            yue = (yue - 1 + tmpCircleCount) % 9 + 1;
            tmpCircleR -= 2;
            tmpCilr++;
            tmpCircleCount = 4 + (tmpCircleR - 2) * 4;
        }

        int pos = 0;
        if ((num & 1) == 1) {

        } else {

        }

        return 1;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().orchestraLayout(5, 2, 2);
        System.out.println(i);
    }
}