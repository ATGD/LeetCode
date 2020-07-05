package Problem_1154_一年中的第几天;

class Solution {
    public int dayOfYear(String date) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int sum = 0;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            daysInMonth[1] = 29;
        for (int i = 0; i < month; i++) {
            if (i != month - 1)
                sum += daysInMonth[i];
            else
                sum += day;
        }
        return sum;
    }
}