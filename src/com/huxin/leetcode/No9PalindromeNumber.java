package com.huxin.leetcode;

public class No9PalindromeNumber {
    /*
     每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     每取一个最低位数字，x 都要自除以 10
     判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，
     最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
     */
    public boolean isPalindrome(int x) {
        if(x < 0 ||  (x%10 == 0 && x != 0))
            return false;

        int revertNumber = 0;
        while (x > revertNumber){
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertNumber || x == revertNumber/10;
    }
}
