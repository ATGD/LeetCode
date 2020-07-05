package test;

public class  StringMatch {
    public boolean match(String str, String exp) {
        if (str == null && exp == null) return true;
        if (exp == null && exp != null) return false;
        if (exp != null && exp == null) return false;
        if (exp.equals("*") && str != null) return false;
        char c = exp.charAt(0);
        if (c == '.') {
            if (str == null) return false;
            return match(str.substring(1), exp.substring(1));
        } else if (c == '*') {
            if (exp.length() >= 1) {
                if (exp.charAt(1) == '*') return false;
            }
            for (int i = 0; i < str.length(); i++) {
                boolean result = match(str.substring(i), exp.substring(1));
                if (result) return true;
            }
        } else {
            if (str.charAt(0) != c) return false;
            return match(str.substring(1), exp.substring(1));
        }
        return false;
    }
}

class Test2 {
    public static void main(String[] args) {
        Number num = 127;
        Number _num = 127;
        compare(num, _num);
    }

    private static boolean compare(Number num, Number num1) {
        if (num == null && num1 == null) return true;
        if (num == null ^ num1 == null) return false;
        return num.doubleValue() == num.doubleValue();
    }
}
