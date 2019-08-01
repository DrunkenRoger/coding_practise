package com.huxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1)
            return res;
        Arrays.sort(nums);
        backtrack(res, nums, target, new ArrayList<Integer>(),0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, int target, ArrayList<Integer> temp, int start) {
        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start; i<nums.length; i++){
            // 去重
            if(i>start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            backtrack(res,nums,target-nums[i],temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
