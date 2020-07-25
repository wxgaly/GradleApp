package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-25 20:44
 * @version V1.0
 *
    You have a set of tiles, where each tile has one letter tiles[i] printed on it. 
    Return the number of possible non-empty sequences of letters you can make.

     

    Example 1:

    Input: "AAB"
    Output: 8
    Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
    Example 2:

    Input: "AAABBC"
    Output: 188
     

    Note:

    1 <= tiles.length <= 7
    tiles consists of uppercase English letters.

 *
 */
fun main() {
    println(numTilePossibilities("AAB"))
    assert(numTilePossibilities("AAB") == 8)
    assert(numTilePossibilities("AAABBC") == 18)
    println(numTilePossibilities("AAABBC"))
}

val hashSet = hashSetOf<String>()

fun numTilePossibilities(tiles: String): Int {
    if (tiles.isEmpty()) {
        return 0
    }
    findAllResult(tiles, "", arrayListOf())
    return hashSet.size
}

fun findAllResult(tiles: String, current: String, list: MutableList<Int>) {
    for (i in 0 until tiles.length) {
        if (!list.contains(i)) {
            hashSet.add(current + tiles[i])
            list.add(i)
            findAllResult(tiles, current + tiles[i], list)
            list.remove(i)
        }
    }
}
