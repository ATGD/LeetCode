package Problem_0079_单词搜索

internal class Solution {
    var directs =
        arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    private lateinit var hasWalk: Array<Array<Boolean>>
    fun exist(board: Array<Array<Char>>, word: String?): Boolean {
        if (null == word || word.isEmpty()) return false
        val words = word.toCharArray()
        hasWalk = Array(board.size) { Array(board[0].size) { false } }
        for (row in board.indices) {
            for (column in board[row].indices) {
                if (board[row][column] == words[0]) {
                    val result = hasContains(board, row, column, word, 0)
                    if (result) return true
                }
            }
        }
        return false
    }

    private fun hasContains(
        board: Array<Array<Char>>, row: Int, column: Int, word: String, wordIndex: Int
    ): Boolean {
        if (wordIndex >= word.length) return true
        if (!isInRange(board, row, column) || board[row][column] != word[wordIndex]) return false
        if (hasWalk[row][column]) return false
        for (direct in directs) {
            hasWalk[row][column] = true
            val result = hasContains(board, row + direct[0], column + direct[1], word, wordIndex + 1)
            if (result) return true
            hasWalk[row][column] = false
        }
        return false
    }

    private fun isInRange(board: Array<Array<Char>>, row: Int, column: Int): Boolean {
        return row >= 0 && row < board.size && column >= 0 && column < board[0].size
    }
}

internal object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val board =
            arrayOf(arrayOf('A', 'B', 'C'), arrayOf('A', 'B', 'C'), arrayOf('A', 'B', 'C'))
        val asa = Solution().exist(board, "ABCCBA")
        println(asa)
    }
}