package Gold_08_09_括号;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthes(n, n, "", result);
        return result;
    }

    private void generateParenthes(int leftRetains, int rightRetains, String tmp, List<String> result) {
        if (leftRetains == 0 && rightRetains == 0) {
            result.add(tmp);
        } else {
            if (leftRetains == 0) {
                generateParenthes(leftRetains, rightRetains - 1, tmp + ")", result);
            } else if (leftRetains == rightRetains) {
                generateParenthes(leftRetains - 1, rightRetains, tmp + "(", result);
            } else {
                generateParenthes(leftRetains, rightRetains - 1, tmp + ")", result);
                generateParenthes(leftRetains - 1, rightRetains, tmp + "(", result);
            }
        }
    }
}

class Test{
    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(10);
        System.out.println(strings);
    }
}