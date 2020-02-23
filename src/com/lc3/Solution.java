package com.lc3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *HashSet
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
            set.add(s.charAt(fast++));//eventually can add fast into set
        }
        return max;
    }
}
/*
* HashMap 直接找到位置
*
* */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int maxLen = 0;

        for(int front=0,end=0; end<s.length();end++){
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                front = Math.max(front, map.get(c)+1);//避免跳过来导致的跳回去
            }
            maxLen = Math.max(maxLen, end-front+1);
            map.put(c,end);
        }

        return maxLen;
    }
}