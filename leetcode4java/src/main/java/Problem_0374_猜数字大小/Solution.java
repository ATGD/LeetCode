package Problem_0374_猜数字大小;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution {

    int originNum = 0;

    public Solution(int originNum) {
        this.originNum = originNum;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            //这里注意，不能写 int mid = (low + high) / 2;因为hight有可能是接近Integer.MAX_VALUE的值，这样一加，超出范围会显示负值
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int guess(int num) {
        if (originNum < num) return -1;
        else if (originNum == num) return 0;
        else return 1;
    }
}

class Test {

    public static void main(String[] args) {
        Solution solution = new Solution(2);
        int i = solution.guessNumber(2);
        System.out.println(i);
    }
}

