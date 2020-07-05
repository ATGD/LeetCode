package Problem_0921_使括号有效的最少添加;

class Solution {
    public int minAddToMakeValid(String S) {
//        Stack<Character> simpleStack = new Stack<>();
//        int shoudAdd = 0;
//        for (char c : S.toCharArray()) {
//            if (c == '(') {
//                simpleStack.push(c);
//            } else {
//                if (simpleStack.size() == 0 || simpleStack.pop() != '(') {
//                    shoudAdd++;
//                }
//            }
//        }
//        shoudAdd += simpleStack.size();
//        return shoudAdd;
        int state = 0;
        int shoudAdd = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                state++;
            } else {
                if (state == 0 || --state < 0) {
                    shoudAdd++;
                    state = 0;
                }
            }
        }
        shoudAdd += Math.abs(state);
        return shoudAdd;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().minAddToMakeValid(")((()((())()()(");
        System.out.println(i);
    }
}

