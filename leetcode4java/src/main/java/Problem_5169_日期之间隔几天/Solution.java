package Problem_5169_日期之间隔几天;

class Solution {
    int[] _365M = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        int[] dates1 = parseDate(date1), dates2 = parseDate(date2);
        return Math.abs(calculateDays(dates1[0], dates1[1], dates1[2]) - calculateDays(dates2[0], dates2[1], dates2[2]));
    }

    int calculateDays(int year, int month, int day) {
        int dayC1 = day - 1;
        for (int i = month; i > 1; i--) dayC1 += _365M[i - 1 - 1];
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month > 2) dayC1++;
        dayC1 += (365 * (year - 1) + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400);
        return dayC1;
    }

    int[] parseDate(String date) {
        return new int[]{Integer.valueOf(date.substring(0, 4)), Integer.valueOf(date.substring(5, 7)), Integer.valueOf(date.substring(8, 10))};
    }
}

class Test {
    public static void main(String[] args) {
//        int i = new Solution().daysBetweenDates("1971-06-29", "2010-09-23");
//        0,4,8,12,16,20,24,28,32,36,40,44,48,52,56,60,64,68,72,76,80,84,88,92,96
        int i = new Solution().daysBetweenDates("2009-08-18", "2080-08-08");
        System.out.println(i);
    }
}
