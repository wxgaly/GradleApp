package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-28 14:06
 * @version V1.0
 *
 *
    Write a method to sort an array of strings so that all the anagrams are in the same group.

    Note: This problem is slightly different from the original one the book.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
    ["ate","eat","tea"],
    ["nat","tan"],
    ["bat"]
    ]
    Notes:

    All inputs will be in lowercase.
    The order of your output does not matter.

 *
 */
fun main() {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach { list ->
        list.forEach {
            print("$it, ")
        }

        println(",")
    }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val tempSortList = strs.map {
        val chars = it.toCharArray()
        Arrays.sort(chars)
        String(chars)
    }

    val sortMap = mutableMapOf<String, MutableList<String>>()
    for (i in 0 until strs.size) {
        val value = sortMap[tempSortList[i]]
        if (value != null) {
            value.add(strs[i])
        } else {
            sortMap[tempSortList[i]] = mutableListOf(strs[i])
        }
    }

    val res = mutableListOf<List<String>>()

    sortMap.values.forEach {
        res.add(it)
    }
    return res
}
