package Problem_0994_腐烂的橘子;


import java.util.*

internal class Solution {
    //我发觉kotlin声明个二维数据贼蠢,写法太麻烦
    var arround =
        arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    var count = 0
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = LinkedList<Array<Int>>()
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        //初次遍历数据内的坏橘子放到队列里
        for (i in grid.indices)
            for ((j, value) in grid[i].withIndex())
                if (grid[i][j] == 2) queue.addLast(arrayOf(i, j))
        while (queue.size > 0) {
            //记录当前count批次拥有size个坏橘子
            val size = queue.size
            //标志本批次是否能找到新感染的橘子
            var hasFresh = false
            //遍历count批次，存在的坏橘子
            for (i in 0 until size) {
                val pos = queue.pollFirst()
                for (j in arround.indices) {
                    val tmpY = pos[0] + arround[j][0]
                    val tmpX = pos[1] + arround[j][1]
                    if (tmpY >= 0 && tmpY < grid.size && tmpX >= 0 && tmpX < grid[0].size && grid[tmpY][tmpX] == 1) {
                        hasFresh = true
                        grid[tmpY][tmpX] = 2
                        queue.addLast(arrayOf(tmpY, tmpX))
                    }
                }
            }
            //确定经过一次感染
            if (hasFresh) count++
        }
        //如果还有新鲜的橘子没被感染，就返回-1
        return if (findRottingCount(grid) == 0) count else -1
    }

    fun findRottingCount(grid: Array<IntArray>): Int {
        var count = 0
        for (i in grid.indices) for (element in grid[i]) if (element == 1) count++
        return count
    }
}

internal object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val i = Solution().orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)
            )
        )
        println(i)
    }
}