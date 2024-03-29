package com.huxin.leetcode;

public class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length < 1)
            return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
