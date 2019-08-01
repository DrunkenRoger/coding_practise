package com.huxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> list, int start) {
        if (target < 0)
            return;
        if (target == 0){
            res.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target-candidates[i], res, new ArrayList<>(list), i);
            list.remove(list.size()-1);
        }
    }
}
