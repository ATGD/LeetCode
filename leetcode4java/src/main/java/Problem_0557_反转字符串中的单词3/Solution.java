package Problem_0557_反转字符串中的单词3;

class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}

class Test {
    public static void main(String[] args) {
        String sb = "1 2 ";
        String[] s = sb.split(" ");
        System.out.println(s);
    }
}

