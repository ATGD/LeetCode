package Problem_5661_替换隐藏数字得到的最晚时间;


class Solution {
    public String maximumTime(String time) {
        String[] timeStr = time.split(":");
        if (timeStr[0].equals("??")) {
            timeStr[0] = "23";
        }
        timeStr[0] = timeStr[0].replaceAll("\\?", "9");
        timeStr[1] = timeStr[1].replaceAll("\\?", "9");

        int hourInt = Integer.parseInt(timeStr[0]);

        if (hourInt > 93) {
            timeStr[0] = "1" + timeStr[0].charAt(1);
        } else if (hourInt >= 90) {
            timeStr[0] = "2" + timeStr[0].charAt(1);
        } else if (hourInt == 29) {
            timeStr[0] = "23";
        }

        int minuteInt = Integer.parseInt(timeStr[0]);

        if (minuteInt >= 90) {
            timeStr[1] = "5" + timeStr[1].charAt(1);
        }
        return timeStr[0] + ":" + timeStr[1];
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().maximumTime("??:3?");
        System.out.println(s);
    }
}