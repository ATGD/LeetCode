package Problem_5430_设计浏览器历史记录;

import java.util.LinkedList;

class BrowserHistory {

    LinkedList<String> stack = new LinkedList<>();
    int tempIndex = -1;

    public BrowserHistory(String homepage) {
        stack.clear();
        stack.offer(homepage);
        tempIndex = 0;
    }

    public void visit(String url) {
        if (tempIndex != stack.size() - 1) {
            while (stack.size() - 1 > tempIndex) {
                stack.removeLast();
            }
        }
        stack.offer(url);
        tempIndex = stack.size() - 1;
    }

    public String back(int steps) {
        steps = Math.min(steps, Math.max(tempIndex, 0));
        tempIndex -= steps;
        return stack.get(tempIndex);
    }

    public String forward(int steps) {
        steps = Math.min(steps, Math.max(0, stack.size() - tempIndex - 1));
        tempIndex += steps;
        return stack.get(tempIndex);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

class Test {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        String result1 = browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        String result2 = browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        String result3 = browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        String result5 = browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        String result6 = browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        String result7 = browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
        System.out.println("finish");
    }
}