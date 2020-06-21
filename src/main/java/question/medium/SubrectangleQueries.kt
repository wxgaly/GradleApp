package question.medium

import java.util.ArrayList
import java.util.HashMap

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-21 23:01
 * @version V1.0
 *
Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:

1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)

Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
2. getValue(int row, int col)

Returns the current value of the coordinate (row,col) from the rectangle.
 

Example 1:

Input
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
Output
[null,1,null,5,5,null,10,5]
Explanation
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
// The initial rectangle (4x3) looks like:
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // return 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// After this update the rectangle looks like:
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5
subrectangleQueries.getValue(0, 2); // return 5
subrectangleQueries.getValue(3, 1); // return 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// After this update the rectangle looks like:
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10
subrectangleQueries.getValue(3, 1); // return 10
subrectangleQueries.getValue(0, 2); // return 5
Example 2:

Input
["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
[[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
Output
[null,1,null,100,100,null,20]
Explanation
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
subrectangleQueries.getValue(0, 0); // return 1
subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
subrectangleQueries.getValue(0, 0); // return 100
subrectangleQueries.getValue(2, 2); // return 100
subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
subrectangleQueries.getValue(2, 2); // return 20
 

Constraints:

There will be at most 500 operations considering both methods: updateSubrectangle and getValue.
1 <= rows, cols <= 100
rows == rectangle.length
cols == rectangle[i].length
0 <= row1 <= row2 < rows
0 <= col1 <= col2 < cols
1 <= newValue, rectangle[i][j] <= 10^9
0 <= row < rows
0 <= col < cols
 *
 */
fun main() {

}

class SubrectangleQueries(var rectangle: Array<IntArray>) {

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (i in row1..row2) {
            for (j in col1..col2) {
                rectangle[i][j] = newValue
            }
        }
    }

    fun getValue(row: Int, col: Int): Int {
        return rectangle[row][col]
    }

}

data class DataCls(
        var row1: Int,
        var col1: Int,
        var row2: Int,
        var col2: Int,
        var newValue: Int
)


/**
 * 不通过暴力更新的方式
 */
class SubrectangleQueries1(var rectangle: Array<IntArray>) {

    val list = ArrayList<ArrayList<Int>>()

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        list.add(arrayListOf(row1, col1, row2, col2, newValue))
    }

    fun getValue(row: Int, col: Int): Int {

        var i = list.size - 1
        while (i >= 0) {
            if (list[i][0] <= row && row <= list[i][2] &&
                    list[i][1] <= col && col <= list[i][3])
                return list[i][4]
            i--
        }
        return rectangle[row][col]

    }

}
