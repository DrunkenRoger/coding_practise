package com.huxin.leetcode;

public class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2)
            return;

        int firstIndex = -1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                firstIndex = i-1;
                break;
            }
        }

        if(firstIndex == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        int secondIndex = -1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > nums[firstIndex]){
                secondIndex = i;
                break;
            }
        }

        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex+1, nums.length-1);
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
