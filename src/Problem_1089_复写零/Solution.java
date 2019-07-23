package Problem_1089_复写零;

class Solution {
    public void duplicateZeros(int[] arr) {
        int[] rulerArr = arr.clone();
        int rulerIndex = 0;
        for (int i = 0; i < rulerArr.length; i++) {
            if (rulerIndex >= rulerArr.length)
                return;
            if (rulerArr[i] != 0) {
                arr[rulerIndex] = rulerArr[i];
                rulerIndex++;
            } else {
                if (rulerIndex == arr.length - 1) {
                    arr[rulerIndex] = 0;
                    return;
                } else {
                    arr[rulerIndex] = 0;
                    arr[rulerIndex + 1] = 0;
                    rulerIndex += 2;
                }
            }
        }
    }
}

class Text {
    public static void main(String[] args) {
        int[] ints = new int[]{1,7,0,3,7,0,2,0,3,7};
        new Solution().duplicateZeros(ints);
        System.out.println(ints);
    }
}

