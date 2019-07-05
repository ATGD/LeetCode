package Problem_1071_字符串的最大公因子;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String min = "";
        int index = 1;
        if (str1.replaceAll(str2, "").equals(""))
            return str2;
        if (str2.replaceAll(str1, "").equals(""))
            return str1;
        while (index <= ((Math.min(str1.length(), str2.length()))) && str1.substring(0, index).equals(str2.substring(0, index))) {
            if (str1.charAt(index - 1) != str2.charAt(index - 1)) {
                return min;
            }
            String commonWill = str1.substring(0, index);
            if (str1.replaceAll(commonWill, "").equals("") &&
                    str2.replaceAll(commonWill, "").equals("")) {
                min = commonWill;
                break;
            }
            index++;
        }
        if (!min.equals("")) {
            String tempMM = min;
            String tempMin = min;
            int reCount = 1;
            while (reCount * tempMM.length() <= Math.min(str1.length(), str2.length())) {
                if (str1.replaceAll(tempMin, "").equals("") &&
                        str2.replaceAll(tempMin, "").equals("")) {
                    min = tempMin;
                }
                reCount++;
                tempMin += tempMM;
            }
        }
        return min;
    }
}

class Text {
    public static void main(String[] args) {
        String s = new Solution().gcdOfStrings("ABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABC", "ABCABCABCABCABCABCABCABCABCABCABCABC");
        System.out.println(s);
    }
}

