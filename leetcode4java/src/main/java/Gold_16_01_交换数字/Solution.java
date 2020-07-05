package Gold_16_01_交换数字;

class Solution {
    public int[] swapNumbers(int[] numbers) {
        /*numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];*/

        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}

class Test {
    public static void main(String[] args) {
        int[] ints = new Solution().swapNumbers(new int[]{1, 2});
        System.out.println(ints);
    }
}