package Problem_5638_吃苹果的最大数目;

class Solution {
    //false,true,false,true
    public int eatenApples(int[] apples, int[] days) {
        int day = 0;
        int eatIndex = 0;
        int eatCount = 0;

        while (eatIndex < apples.length) {
            while ((eatIndex < apples.length) && (
                    (eatIndex + days[eatIndex] - day) <= 0)
            ) {
                eatIndex++;
            }
            eatCount += (apples[eatIndex] - day);
            day += apples[eatIndex];
        }
        return eatCount;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().eatenApples(
                new int[]{
                        1, 2, 3, 5, 2
                },
                new int[]{
                        3, 2, 1, 4, 2
                }
        );
        System.out.println(i);
    }
}