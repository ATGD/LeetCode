package Problem_0860_柠檬水找零;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[2];
        for (int bill : bills) {
            if (bill == 5)
                change[0]++;
            else if (bill == 10) {
                if (change[0] > 0) {
                    change[1]++;
                    change[0]--;
                } else return false;
            } else {
                if (change[1] > 0 && change[0] > 0) {
                    change[1]--;
                    change[0]--;
                } else if (change[0] >= 3) change[0] -= 3;
                else return false;
            }
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().lemonadeChange(new int[]{
                5, 5, 5, 10, 5, 20
        });
        System.out.println(b);
    }
}