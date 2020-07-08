package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-08 16:11
 * @version V1.0
 *
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service.
There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

 *
 */
fun main() {

}

/**
 *
    方法 5：随机固定长度加密 [Accepted]
    算法

    在这种方法中，我们像方法 2 一样再次使用数字和字母表集合来为 URL 生成加密结果。这种方法中，加密后的长度固定是 6 位。
    如果产生出来的加密结果与之前产生的结果一样，就换一个新的加密结果。
 */
class Codec() {

    val alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val map = HashMap<String, String>()
    var rand = Random()
    var key = getRand()

    fun getRand(): String {
        val sb = StringBuilder()
        for (i in 0 until 6) {
            sb.append(alphabet[(rand.nextInt(62))])
        }
        return sb.toString();
    }

    fun encode(longUrl: String): String {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/$key";
    }

    fun decode(shortUrl: String): String? {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""))
    }

}
