package com.huxin.leetcode;

public class No34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums,target);
        int last = binarySearch(nums,target+1)-1;
        if(first == nums.length || nums[first]!=target){
            return new int[]{-1,-1};
        }else
            return new int[]{first,Math.max(last,first)};
    }

    private int binarySearch(int[] nums, int target){
        int l=0, h=nums.length;
        while(l<h){
            int m = l+(h-l)/2;
            if(nums[m]>=target)
                h=m;
            else
                l=m+1;
        }
        return l;
    }
}
