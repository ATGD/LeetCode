package Problem_5353_灯泡开关3;

class Solution {
    int[] N;

    public int numTimesAllBlue(int[] light) {
        int count = 0;
        int max = 0;
        N = new int[light.length];
        for (int k = 0; k < light.length; k++) {
            int index = light[k] - 1;
            if (index < light.length) {
                N[index] = 1;
                max = Math.max(max, index);
                if (checkAllIs(max))
                    count++;
            }
        }
        return count;
    }

    private boolean checkAllIs(int index) {
        for (int i = 0; i <= index; i++) {
            if (N[i] == 0) {
                return false;
            } else if (N[i] == 1) {
                N[i] = 2;
            }
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numTimesAllBlue(new int[]{
                4,1,2,3
                //2,2,0,1
        });
        System.out.println(i);
    }
}