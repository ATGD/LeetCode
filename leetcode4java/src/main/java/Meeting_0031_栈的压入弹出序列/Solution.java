package Meeting_0031_栈的压入弹出序列;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] hasPoped = new int[pushed.length];
        int tmpIndex = -1;
        for (int i = 0; i < popped.length; i++) {
            int value = popped[i];
            int saveIndex = tmpIndex;
            //向左只能一位非已经pop的元素
            for (int j = tmpIndex - 1; j >= 0; ) {
                if (hasPoped[j] == -1) j--;
                else if (pushed[j] == value) {
                    tmpIndex = j;
                    hasPoped[j] = -1;
                    break;
                } else break;
            }
            //向右
            if (saveIndex == tmpIndex) {
                for (int j = tmpIndex + 1; j < pushed.length; j++) {
                    if (hasPoped[j] == -1) continue;
                    if (pushed[j] == value) {
                        tmpIndex = j;
                        hasPoped[j] = -1;
                        break;
                    }
                }
                if (saveIndex == tmpIndex) return false;
            }
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{2,3,5,4,1});
        System.out.println(b);
    }
}
