package com.huxin.leetcode;

public class No10RegularExpressionMatching {
    /*
    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     */

    // 如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。
    // 如果模式串中有星号，它会出现在第二个位置，即pattern[1]。这种情况下，我们可以直接忽略模式串中这一部分，
    // 或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即 pattern[0] 。
    // 如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    /*
    动态方程：

    p[j] == s[i]:dp[i][j] = dp[i-1][j-1]

    p[j] == ".":dp[i][j] = dp[i-1][j-1]

    p[j] =="*":

        3.1 p[j-1] != s[i]:dp[i][j] = dp[i][j-2]

        3.2 p[i-1] == s[i] or p[i-1] == ".":

            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况

            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况

            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
     */
    public boolean isMatchDP(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
