package Gold_08_07_无重复字符串的排列组合;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        list.add(S);
        for (int i = 0; i < S.length() - 1; i++) {
            int size = list.size();
            for (int j = i + 1; j < S.length(); j++) {
                for (int index = 0; index < size; index++) {
                    list.add(swap(list.get(index), i, j));
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private String swap(String s, int pos1, int pos2) {
        char[] chars = s.toCharArray();
        chars[pos1] ^= chars[pos2];
        chars[pos2] ^= chars[pos1];
        chars[pos1] ^= chars[pos2];
        return new String(chars);
    }
}

class Test {
    public static void main(String[] args) {
        //1+3+4+8
        String[] result = new Solution().permutation("abcd");
        System.out.println(result);
//        abcd
//        bacd
//        cbad
//        dbca

//        acbd
//        bcad
//        cabd
//        dcba
//        adcb
//        bdca
//        cdab
//        dacb
//        abdc
//        badc
//        cbda
//        dbac
//        acdb
//        bcda
//        cadb
//        dcab
//        adbc
//        bdac
//        cdba
//        dabc


        //1,2,3,4
        //1,2,4,3
        //1,3,2,4
        //1,4,3,2
        //1,4,2,3
        //1,3,4,2

    }
}