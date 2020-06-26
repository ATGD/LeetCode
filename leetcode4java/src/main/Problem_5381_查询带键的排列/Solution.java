package Problem_5381_查询带键的排列;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m];
        int[] result = new int[queries.length];
        for (int i = 0; i < p.length; i++) p[i] = i + 1;
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            for (int j = 0; j < p.length; j++) {
                if (target == p[j]) {
                    for (int k = j; k > 0; k--) {
                        p[k] = p[k - 1];
                    }
                    p[0] = target;
                    result[i] = j;
                }
            }
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] result = new Solution().processQueries(new int[]{
                7, 5, 5, 8, 3
        }, 8);
        System.out.println(result);
    }
}