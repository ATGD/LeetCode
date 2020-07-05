package Meeting_0064_从1加到n;

class Solution {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (sum > 0 && (sum += sumNums(n - 1)) > 0);
        return sum;
    }
}