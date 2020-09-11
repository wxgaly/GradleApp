package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-11 13:51
 * @version V1.0
 *

    On an 8x8 chessboard, there can be multiple Black Queens and one White King.

    Given an array of integer coordinates queens that represents the positions of the Black Queens,
    and a pair of coordinates king that represent the position of the White King,
    return the coordinates of all the queens (in any order) that can attack the King.

     

    Example 1:



    Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
    Output: [[0,1],[1,0],[3,3]]
    Explanation: 
    The queen at [0,1] can attack the king cause they're in the same row.
    The queen at [1,0] can attack the king cause they're in the same column.
    The queen at [3,3] can attack the king cause they're in the same diagnal.
    The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1].
    The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0].
    The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.


    Example 2:



    Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
    Output: [[2,2],[3,4],[4,4]]
    Example 3:



    Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
    Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
     

    Constraints:

    1 <= queens.length <= 63
    queens[0].length == 2
    0 <= queens[i][j] < 8
    king.length == 2
    0 <= king[0], king[1] < 8
    At most one piece is allowed in a cell


 *
 */
fun main() {
//    printQueens(queensAttacktheKing(
//            arrayOf(
//                    intArrayOf(0, 1),
//                    intArrayOf(1, 0),
//                    intArrayOf(4, 0),
//                    intArrayOf(0, 4),
//                    intArrayOf(3, 3),
//                    intArrayOf(2, 4)
//            ),
//            intArrayOf(0, 0)))

//    printQueens(queensAttacktheKing(
//            arrayOf(
//                    intArrayOf(0, 0),
//                    intArrayOf(1, 1),
//                    intArrayOf(2, 2),
//                    intArrayOf(3, 4),
//                    intArrayOf(3, 5),
//                    intArrayOf(4, 4),
//                    intArrayOf(4, 5)
//            ),
//            intArrayOf(3, 3)))

    printQueens(queensAttacktheKing1(
            arrayOf(
                    intArrayOf(5, 6),
                    intArrayOf(7, 7),
                    intArrayOf(2, 1),
                    intArrayOf(0, 7),
                    intArrayOf(1, 6),
                    intArrayOf(5, 1),
                    intArrayOf(3, 7),
                    intArrayOf(0, 3),
                    intArrayOf(4, 0),
                    intArrayOf(6, 3),
                    intArrayOf(5, 0),
                    intArrayOf(0, 4),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(6, 4),
                    intArrayOf(5, 4),
                    intArrayOf(0, 0),
                    intArrayOf(2, 6),
                    intArrayOf(4, 5),
                    intArrayOf(5, 2),
                    intArrayOf(1, 4),
                    intArrayOf(7, 5),
                    intArrayOf(2, 3),
                    intArrayOf(0, 5),
                    intArrayOf(4, 2),
                    intArrayOf(1, 0),
                    intArrayOf(2, 7),
                    intArrayOf(0, 1),
                    intArrayOf(4, 6),
                    intArrayOf(6, 1),
                    intArrayOf(0, 6),
                    intArrayOf(4, 3),
                    intArrayOf(1, 7)
            ),
            intArrayOf(3, 4)))


}

fun printQueens(res: List<List<Int>>) {
    res.forEach { list ->
        print("[")
        list.forEach {
            print("$it, ")
        }
        print("]")
    }
}

fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
    //为了快速查找，做一个hash映射，因为是二维数组，所以直接让x作为十位，y作为个位,(0,1) = 1，(1, 0) = 10
    val map = hashMapOf<Int, IntArray?>()
    queens.forEach {
        map[it[0] * 10 + it[1]] = it
    }

    val res = arrayListOf<ArrayList<Int>>()
    //8 * 8
    val size = 8
    //最多只会出现8个结果，依次从横、竖、斜去遍历，双向，只需四次遍历
    //1.横方向
    val x = king[0]
    val y = king[1]
    for (i in x - 1 downTo 0) {
        val ints = map[i * 10 + y]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
    }

    for (i in x + 1 until size) {
        val ints = map[i * 10 + y]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
    }

    //2. 纵方向
    for (j in y - 1 downTo 0) {
        val ints = map[x * 10 + j]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
    }

    for (j in y + 1 until size) {
        val ints = map[x * 10 + j]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
    }

    //3. 斜方向-右
    var x1 = x - 1
    var y1 = y - 1
    while (x1 != -1 && y1 != -1) {
        val ints = map[x1 * 10 + y1]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
        x1--
        y1--
    }

    x1 = x + 1
    y1 = y + 1
    while (x1 != size && y1 != size) {
        val ints = map[x1 * 10 + y1]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
        x1++
        y1++
    }

    //4. 斜方向-左
    x1 = x + 1
    y1 = y - 1
    while (x1 != size && y1 != 0) {
        val ints = map[x1 * 10 + y1]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
        x1++
        y1--
    }

    x1 = x - 1
    y1 = y + 1
    while (x1 != 0 && y1 != size) {
        val ints = map[x1 * 10 + y1]
        if (ints != null) {
            res.add(arrayListOf(ints[0], ints[1]))
            break
        }
        x1--
        y1++
    }

    return res
}

fun queensAttacktheKing1(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
    val res = LinkedList<List<Int>>()
    //标志数组
    val flag = Array(8) { BooleanArray(8) }
    for (queen in queens) {
        flag[queen[0]][queen[1]] = true
    }

    //8个方向                         右     左    上    下    右上   右下   左上    左下
    val direction = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 1),
            intArrayOf(1, -1),
            intArrayOf(-1, 1),
            intArrayOf(-1, -1)
    )

    //从第一个方向开始到第八个方向
    for (i in 0 until direction.size) {
        //起始位置为king的坐标,找到第一个皇后停止这个方向的查找，或者直到出界
        var x = king[0]
        var y = king[1]
        while (x in 0..7 && y >= 0 && y < 8) {
            if (flag[x][y]) {
                res.add(Arrays.asList(x, y))
                break
            }
            x += direction[i][0]
            y += direction[i][1]
        }
    }

    return res
}
