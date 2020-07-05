package Problem_0778_水位上升的泳池中游泳;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> repareToValidList = new ArrayList<>();
    List<int[]> canReachList = new ArrayList<>();
    int[][] grid;

    public int swimInWater(int[][] grid) {
        this.grid = grid;
        int nowDeep = 0;
        return 0;
    }

    /**
     * 将临近的点添加到点集里
     *
     */
    public void addToCollection(int oldDeep, int nowDeep) {
        for (int[] ints : repareToValidList) {
            int value = grid[ints[0]][ints[1]];
//            if (value>oldDeep)
        }
    }

    public int selectRaiseDeep(int N) {
        int minDeep = 0;
        for (int[] ints : repareToValidList) {
            minDeep = Math.min(
                    minDeep, grid[
                            ints[0]]
                            [ints[1]
                            ]
            );
        }
        return minDeep;
    }

    public boolean isInCollection(int[] posAxis) {
        for (int[] ints : canReachList) {
            if (ints[0] == posAxis[0]
                    && ints[1] == posAxis[1]) {
                return true;
            }
        }
        return false;
    }
}
