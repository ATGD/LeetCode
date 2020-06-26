package Problem_5369_统计作战单位数;

class Solution {

    int count = 0;

    public int numTeams(int[] rating) {
        for (int i = 0; i < rating.length; i++) {
            AscCount(rating, i, 1, rating[i], true);
            AscCount(rating, i, 1, rating[i], false);
        }
        return count;
    }

    private void AscCount(int[] rating, int startIndex, int memberCount, int baseRate, boolean isAsc) {
        if (memberCount >= 3) {
            count++;
            return;
        }
        for (int i = startIndex + 1; i < rating.length; i++) {
            if (isAsc ? (rating[i] > baseRate) : (rating[i] < baseRate)) {
                AscCount(rating, i, memberCount + 1, rating[i], isAsc);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().numTeams(new int[]{
                2, 5, 3, 4, 1
//                1,2,3
        });
        System.out.println(i);
    }
}