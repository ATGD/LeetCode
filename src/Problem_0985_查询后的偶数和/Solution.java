package Problem_0985_查询后的偶数和;

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] results = new int[queries.length];
        for (int i : A) if ((i & 1) == 0) sum += i;
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if ((A[index] & 1) == 0) sum -= A[index];
            A[index] += val;
            if ((A[index] & 1) == 0) sum += A[index];
            results[i] = sum;
        }
        return results;
    }
}
