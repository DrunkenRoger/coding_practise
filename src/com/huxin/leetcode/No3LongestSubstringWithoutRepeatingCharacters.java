package com.huxin.leetcode;

import java.util.HashMap;

public class No3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;
        int res = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right=0; right<s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            res = Math.max(right-left+1, res);
        }
        return res;
    }
}
