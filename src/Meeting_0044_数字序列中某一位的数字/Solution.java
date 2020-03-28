package Meeting_0044_数字序列中某一位的数字;


class Solution {
    public int findNthDigit(int n) {
        long start = 0;
        long end = n;
        while (start < end) {
            long mid = (start + end) / 2;
            long midCount = count(mid);
            if (midCount <= n) {
                start = mid;
            } else {
                end = mid;
            }
            if (end - start <= 1) {
                break;
            }
        }
        long littleSmall = count(start) >= n ? start : end;
        int count = (int) (count(littleSmall) - String.valueOf(littleSmall).length());
        return String.valueOf(littleSmall).charAt(n - count-1) - '0';
    }

    public long count(long n) {
        long sum = 0;
        while (n > 0) {
            String valueStr = String.valueOf(n);
            long length = valueStr.length();
            long min = (int) Math.pow(10, length - 1);
            sum += (n - min + 1) * length;
            n = min - 1;
        }
        return sum;
    }
}

class Test {
    public static void main(String[] args) {
//        0123456789101112131415161718192021222324252627282930
        int nthDigit = new Solution().findNthDigit(1000000000);
        System.out.println(nthDigit);
    }
}