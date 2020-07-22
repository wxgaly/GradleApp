package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-22 14:19
 * @version V1.0
 *

    Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's,
    empty slots are represented with '.'s. You may assume the following rules:
    You receive a valid board, made of only battleships or empty slots.
    Battleships can only be placed horizontally or vertically. In other words,
    they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
    At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
    Example:
    X..X
    ...X
    ...X
    In the above board there are 2 battleships.
    Invalid Example:
    ...X
    XXXX
    ...X
    This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
    Follow up:
    Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

 *
 */
fun main() {

}

/**
 * 半天没看懂题意，其实就是一行或者一列中存不存在联通的图形，如果未联通，则计数一次，然后每次检查当前是x的节点，左边和上边是否窜在x，
 * 则说明是有连续的情况，则视为同一战舰，跳过。
 */
fun countBattleships(board: Array<CharArray>): Int {
    val row = board.size
    val col = board[0].size
    var res = 0
    for (r in 0 until row) {
        for (c in 0 until col) {
            if (board[r][c] == 'X') {
                if (r > 0 && board[r - 1][c] == 'X' || c > 0 && board[r][c - 1] == 'X') {
                    continue
                }
                res++
            }
        }
    }
    return res
}
