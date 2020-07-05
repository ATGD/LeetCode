package Problem_5412_在既定时间做作业的学生人数;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) if (queryTime >= startTime[i] && queryTime <= endTime[i]) count++;
        return count;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().busyStudent(
                new int[]{
                        9,8,7,6,5,4,3,2,1
                },
                new int[]{
                        10,10,10,10,10,10,10,10,10
                },
                5
        );
        System.out.println(i);
    }
}
