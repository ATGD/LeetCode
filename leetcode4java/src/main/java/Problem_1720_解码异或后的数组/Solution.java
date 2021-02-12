package Problem_1720_解码异或后的数组;

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decode[i + 1] = encoded[i] ^ decode[i];
        }
        return decode;
    }
}

class Test {
    public static void main(String[] args) {
        int[] decode = new Solution().decode(
                new int[]{
                        6,2,7,3
                }, 4
        );
        System.out.println(decode);
    }
}