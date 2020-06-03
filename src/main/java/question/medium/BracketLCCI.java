package question.medium;

import java.util.*;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-03 13:54
 * @version V1.0
 *
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
 *
 * Note: The result set should not contain duplicated subsets.
 *
 * For example, given n = 3, the result should be:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 */
public class BracketLCCI {

    public static void main(String[] args) {
        BracketLCCI bracketLCCI = new BracketLCCI();
        for (String s : bracketLCCI.generateParenthesis2(3)) {
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return Collections.singletonList("()");
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();

        }

        return new ArrayList<>(set);
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, 0, "");
        return res;
    }

    void backtrack(List<String> res, int left, int right, String track) {
        if (right != 0 && left != 0) {
            res.add(track);
        } else {
            /*使用一个左括号，同时可使用右括号数加1，这样可避免生成无效括号*/
            if (left > 0) backtrack(res, left - 1, right + 1, track + '(');
            /*可使用的右括号数大于0，则用来补齐原来的左括号*/
            if (right > 0) backtrack(res, left, right - 1, track + ')');
        }
    }

    /*
        解答
        1、回溯算法
        2、()需要配对
    */
    List<String> ans;

    public List<String> generateParenthesis2(int n) {
        ans = new ArrayList();
        char[] cs = new char[n * 2];
        dfs(cs, 0, n, n);
        return ans;
    }

    public void dfs(char[] cs, int k, int leftCnt, int rightCnt) {
        if (leftCnt == 0 && rightCnt == 0) {
            ans.add(new String(cs));
            return;
        }

        if (leftCnt > 0) {
            cs[k] = '(';
            dfs(cs, k + 1, leftCnt - 1, rightCnt);
        }

        if (rightCnt > 0 && rightCnt > leftCnt) {//右边')'必须有足够的'('匹配
            cs[k] = ')';
            dfs(cs, k + 1, leftCnt, rightCnt - 1);
        }

    }

}
