package com.huxin.leetcode;

import java.util.Stack;

public class No32LongestValidParentheses {
    /*
    对于这种括号匹配问题，一般都是使用栈

    从左到右扫描字符串，栈顶保存当前扫描的时候，合法序列前的一个位置位置下标是多少，啥意思嘞？

    我们扫描到左括号，就将当前位置入栈。

    扫描到右括号，就将栈顶出栈（代表栈顶的左括号匹配到了右括号），然后分两种情况。

    栈不空，那么就用当前的位置减去栈顶的存的位置，然后就得到当前合法序列的长度，然后更新一下最长长度。

    栈是空的，说明之前没有与之匹配的左括号，那么就将当前的位置入栈。
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    /*
    动态规划
    dp [ i ] 代表以下标 i 结尾的合法序列的最长长度
    初始化所有的 dp 都等于零
    以左括号结尾的字符串一定是非法序列，所以 dp 是零，不用更改
    以右括号结尾的字符串分两种情况
        右括号前边是 ( ，类似于 ……（）
        dp [ i ] = dp [ i - 2] + 2
        右括号前边是 )，类似于 ……））
        此时我们需要判断 i - dp[i - 1] - 1 （前一个合法序列的前边一个位置） 是不是左括号
     */
    public int longestValidParenthesesDP(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //右括号前边是左括号
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    //右括号前边是右括号，并且除去前边的合法序列的前边是左括号
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
