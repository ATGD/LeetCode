package Problem_0071_简化路径;

import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        StringBuffer tempBuffer = new StringBuffer();
        LinkedList<String> pathStack = new LinkedList<>();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if ((c == '/')
                    || (i == path.length() - 1)) {
                if (c != '/') tempBuffer.append(c);
                String s = tempBuffer.toString();
                if (!s.isEmpty()) {
                    if (s.equals("..")) {
                        pathStack.pollLast();
                    } else if (s.equals(".")) {

                    } else {
                        pathStack.addLast(tempBuffer.toString());
                    }
                    tempBuffer = new StringBuffer();
                }
            } else {
                tempBuffer.append(c);
            }
        }
        StringBuffer resultBuffer = new StringBuffer();
        while (pathStack.size() > 0) {
            String pop = pathStack.pollFirst();
            resultBuffer.append("/" + pop);
        }
        String s = resultBuffer.toString();
        if (s.isEmpty())
            s = "/";
        return s;
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().simplifyPath("/home//foo/");
        System.out.println(s);
    }
}
