package Problem_LCP_2_分式化简;

class Solution {
    public int[] fraction(int[] cont) {
        int up = 1;
        int down = 0;
        for (int i = cont.length - 1; i >= 0; i--) {
            int temp = up;
            up = down;
            down = temp;
            up = down * cont[i] + up;
        }
        return new int[]{up, down};
    }
}

class Test {
    public static void main(String[] args) {
        int[] fraction = new Solution().fraction(new int[]{3, 2});
        System.out.println(fraction);
    }
}

