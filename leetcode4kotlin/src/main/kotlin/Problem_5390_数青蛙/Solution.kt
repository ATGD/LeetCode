package Problem_0994_数青蛙;


class Solution {
    private var map = mapOf('c' to 0, 'r' to 1, 'o' to 2, 'a' to 3, 'k' to 4)

    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        val letters = IntArray(5)
        var max = 0
        for (c in croakOfFrogs) {
            val index = map[c]!!
            letters[index]++
            for (j in 0 until index) if (letters[j] < letters[j + 1]) return -1
            if (c == 'k') {
                for (i in letters) max = Math.max(max, i)
                for (k in letters.indices) letters[k]--
            }
        }
        for (value in letters) if (value != 0) return -1
        return max
    }
}

internal object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val result = Solution().minNumberOfFrogs("croakccrrooaakk")
        println(result)
    }
}