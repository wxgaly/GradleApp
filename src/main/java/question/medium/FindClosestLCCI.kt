package question.medium

import java.util.HashMap
import java.util.HashSet

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-22 14:05
 * @version V1.0
 *

    You have a large text file containing words. Given any two words,
    find the shortest distance (in terms of number of words) between them in the file.
    If the operation will be repeated many times for the same file (but different pairs of words), can you optimize your solution?

    Example:

    Input: words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
    Output: 1
    Note:

    words.length <= 100000


 */
fun main() {

}

/**
 * 通过hashmap将所有字符串作为key，出现的位置的集合为value，
 * 集合可以用set，进行默认排序，然后遍历两边可能出现的最小值
 */
fun findClosest(words: Array<String>, word1: String, word2: String): Int {
    val map = HashMap<String, HashSet<Int>>()
    var res = 1

    for (i in 0 until words.size) {
        val set = map[words[i]]
        if (set != null) {
            set.add(i)
        } else {
            val hashSet = HashSet<Int>()
            hashSet.add(i)
            map[words[i]] = hashSet
        }
    }

    val hashSet1 = map[word1]
    val hashSet2 = map[word2]
    if (hashSet1 != null && hashSet2 != null) {
        hashSet1.forEach { set1 ->
            hashSet2.forEach { set2 ->
                res = Math.min(res, Math.abs(set1 - set2))
            }
        }
    }

    return res
}

/**
 * 双指针，分别记录两个单词的位置，找到最小的即可
 */
fun findClosest1(words: Array<String>, word1: String, word2: String): Int {
    var t1 = -1
    var t2 = -1
    var res = words.size
    for (i in 0 until words.size) {
        if (words[i] == word1) t1 = i
        else if (words[i] == word2) t2 = i
        if (t1 != -1 && t2 != -1) res = Math.min(res, Math.abs(t1 - t2))
        if (res == 1) break
    }
    return res
}
