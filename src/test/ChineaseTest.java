package test;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class ChineaseTest {
    int value = 0;
    int par = 0;

    public ChineaseTest(int value, int par) {
        this.value = value;
        this.par = par;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChineaseTest that = (ChineaseTest) o;
        return value == that.value &&
                par == that.par;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, par);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
         char c = 'a';
         char c1 = '中';
         String str = "a";
         String str1 = "中";
         String str2 = "A";

//         System.out.println("编码为UTF8：");
//         System.out.println("char值为英文字符所占字节长度：" + getBytesUTF8(c).length);
//         System.out.println("char值为中文字符所占字节长度：" + getBytesUTF8(c1).length);
//
//         System.out.println("编码为GBK：");
//         System.out.println("char值为英文字符所占字节长度：" + getBytesGBK(c).length);
//         System.out.println("char值为中文字符所占字节长度：" + getBytesGBK(c1).length);

         System.out.println("编码为UTF8：");
         System.out.println("String值为中文字符所占字节长度：" + str1.getBytes("utf-8").length);

         System.out.println("编码为GBK：");
         System.out.println("String值为英文字符所占字节长度：" + str.getBytes("GBK").length);
         System.out.println("String值为中文字符所占字节长度：" + str1.getBytes("GBK").length);

         //这块str2好像不是全角的，全角占两个字节
         System.out.println("String值为英文字母(全角)所占字节长度：" + str2.getBytes("GBK").length);
    }
}
