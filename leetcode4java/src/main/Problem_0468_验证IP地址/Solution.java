package Problem_0468_验证IP地址;

class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains("+")|| IP.contains("-"))
            return "Neither";
        String[] ipv6Split = IP.split(":");
        String[] ipv4Split = IP.split("\\.");
        if (ipv4Split.length == 4) {
            if (IP.charAt(0) == '.' ||
                    IP.charAt(IP.length() - 1) == '.') {
                return "Neither";
            }
            for (String s : ipv4Split) {
                try {
                    int i = Integer.parseInt(s);
                    if (i >= 0 && i <= 255) {
                        if (s.length() > 1 && s.charAt(0) == '0') {
                            return "Neither";
                        }
                    } else {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (ipv6Split.length == 8) {
            if (IP.charAt(0) == ':' ||
                    IP.charAt(IP.length() - 1) == ':') {
                return "Neither";
            }
            for (String s : ipv6Split) {
                try {
                    int i = Integer.parseInt(s, 16);
                    if (s.length() > 4) {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}

class Test{
    public static void main(String[] args) {
        String s = new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        System.out.println(s);
    }
}

