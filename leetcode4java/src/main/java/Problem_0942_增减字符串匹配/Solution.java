package Problem_0942_增减字符串匹配;

class Solution {
    public int[] diStringMatch(String S) {
        int length = S.length();
        int head = 0, till = length;
        int[] results = new int[length + 1];
        for (int i = 0; i < results.length; i++) {
            if (i == S.length())
                results[i] = head++;
            else if (S.charAt(i) == 'D')
                results[i] = till--;
            else
                results[i] = head++;
        }
        return results;
    }
}


class Test {
    public static void main(String[] args) {

    }
}

