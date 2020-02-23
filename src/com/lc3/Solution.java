package com.lc3;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set set = new HashSet();
        int max = 0;
        int fast = 0, slow = fast;
        //char[] str = s.toCharArray(); 5 millsecs faster
        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                while(s.charAt(slow)!= s.charAt(fast)) {
                    set.remove(s.charAt(slow++));
                }
                set.remove(s.charAt(slow++));
            }//keep [slow,fast] is the latest version
            if(fast-slow+1 > max) max = fast-slow+1;
            set.add(s.charAt(fast++));
        }
        return max;
    }
}
