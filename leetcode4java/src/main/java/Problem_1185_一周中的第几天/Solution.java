package Problem_1185_一周中的第几天;

import java.util.Calendar;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        Calendar instance = Calendar.getInstance();
        instance.set(year, month-1, day);
        int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
        return new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}[dayOfWeek - 1];
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().dayOfTheWeek(27, 1, 2020);
        System.out.println(s);
    }
}