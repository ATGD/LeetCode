package Problem_5686_移动所有球到每个盒子所需的最小操作数;

class Solution {
    public int[] minOperations(String boxes) {
        if (boxes == null || boxes.length() == 0) {
            return null;
        }
        int left = 0;
        int right = 0;

        int baseCount = 0;
        int hasTotal = 0;

        int[] result = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            int currentHas = boxes.charAt(i) - '0';
            hasTotal += currentHas;
            baseCount += i * (currentHas);
        }

        right = hasTotal - left - (boxes.charAt(0) == '1' ? 1 : 0);

        result[0] = baseCount;

        for (int i = 1; i < result.length; i++) {
            int baseAdd = 0;
            if (boxes.charAt(i) == '1') {
                right--;
                baseAdd--;
            }
            baseCount = baseCount + left - right;
            if (boxes.charAt(i - 1) == '1') {
                left++;
                baseAdd++;
            }
            baseCount += baseAdd;
            result[i] = baseCount;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().minOperations("001011");
        System.out.println(ints);
    }
}