package Problem_1108_DefangingIPAddress;

class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}

class Text {
    public static void main(String[] args) {
        String s = new Solution().defangIPaddr("1.1.1.1");
        System.out.println(s);
    }
}

