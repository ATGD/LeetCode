package Meeting_0033_二叉树的后序遍历序列;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length<=2) return true;
        return isLastPostorder(postorder, postorder[postorder.length - 1], 0, postorder.length - 2);
    }

    private boolean isLastPostorder(int[] postorder, int value, int start, int end) {
        if (end - start <= 1) return true;
        if (start < 0 || start >= postorder.length) return true;
        if (end < 0 || end >= postorder.length) return true;
        int index = start;
        for (int j = start; j <= end; j++) {
            if (postorder[j] < value) {
                index++;
            }else break;
        }
        for (int j = index; j <= end; j++) if (postorder[j] < value) return false;
        boolean result = true;
        if (index > start)
            result &= isLastPostorder(postorder, postorder[index - 1], start, index - 2);
        result &= isLastPostorder(postorder, postorder[end], index, end - 1);
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().verifyPostorder(new int[]{
                1,2,3,4,5
        });
        System.out.println(b);
    }
}