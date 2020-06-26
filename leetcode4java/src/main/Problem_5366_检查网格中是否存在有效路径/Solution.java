package Problem_5366_检查网格中是否存在有效路径;


class Solution {
    private int[][] roads = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 1, 0, 0},};//每一种拼图他四个开口的情况，上右下左顺时针方向记录
    private int[][] nexts = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//上右下左四个方向坐标变化
    private int[] tmpIndex = {0, 0};

    public boolean hasValidPath(int[][] grid) {
        int type = grid[0][0] - 1;
        int[] road = roads[type];
        boolean result = false;
        for (int i = 0; i < road.length; i++)
            if (road[i] == 1) {
                tmpIndex = new int[]{0, 0};
                result |= checkPath(grid, (i + 2) % 4);
            }
        return result;
    }

    private boolean checkPath(int[][] grid, int lastExit/*上一个出去的方向*/) {
        while (true) {
            int typeIndex = grid[tmpIndex[0]][tmpIndex[1]] - 1;//得到的是哪一个拼图
            int[] road = roads[typeIndex];//拼图上右下左的开口情况
            if (road[(lastExit + 2) % road.length] != 1) return false;//跟上一个拼接不上
            if (tmpIndex[0] == grid.length - 1 && tmpIndex[1] == grid[0].length - 1) return true;//已经到达目的地
            for (int i = 0; i < road.length; i++) {
                if (road[i] == 1 && i != ((lastExit + 2) % road.length)) {//找到出口，刨除跟上一个块拼接的入口
                    lastExit = i;//出口方向
                    break;
                }
            }
            tmpIndex[0] += nexts[lastExit][0];//下一个块区行
            tmpIndex[1] += nexts[lastExit][1];//下一个块区列
            if (tmpIndex[0] < 0 || tmpIndex[0] >= grid.length || tmpIndex[1] < 0 || tmpIndex[1] >= grid[0].length) return false;
        }
    }
}

class Test {
    public static void main(String[] args) {
        boolean b = new Solution().hasValidPath(new int[][]{
                {4, 1},
                {6, 1}
        });
        System.out.println(b);
    }
}

