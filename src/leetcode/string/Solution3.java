package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * skill: sliding window, jump useless partition
 */
public class Solution3 {
    Map<Character, Integer> map = new HashMap<>();
    int maxLen=0;

    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int slow=0, fast=0;
        while (fast < s.length()) {
            char c = str[fast];
            if(map.containsKey(c)){
                int pos = map.get(c);
                //abccba第二次遇到a时slow已经指向第二个c了所以不能指向第一个b
                slow = slow < pos ? pos + 1 : slow;
            }else{
                int curLen = fast-slow+1;
                maxLen = maxLen < curLen ? curLen : maxLen;
            }
            map.put(c, fast);
            fast++;
        }
        return maxLen;
    }
}
//sliding window
//class lc3 {
//    public int lengthOfLongestSubstring(String s) {
//        Set set = new HashSet();
//        int max = 0;
//        int fast = 0, slow = fast;
//        //char[] str = s.toCharArray(); 5 millsecs faster
//        while (fast < s.length()) {
//            if (set.contains(s.charAt(fast))) {
//                while(s.charAt(slow)!= s.charAt(fast)) {//O(n)
//                    set.remove(s.charAt(slow++));
//                }
//                set.remove(s.charAt(slow++));
//            }//keep [slow,fast] is the latest version
//            if(fast-slow+1 > max) max = fast-slow+1;
//            set.add(s.charAt(fast++));//eventually can add fast into set
//        }
//        return max;
//    }
//}
///*
// * HashMap 直接找到位置jump useless partition, use Max()
// *
// * */
//class Solution {
//    public static int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map= new HashMap<>();
//        int maxLen = 0;
//
//        for(int front=0,end=0; end<s.length();end++){
//            Character c = s.charAt(end);
//            if(map.containsKey(c)){
//                front = Math.max(front, map.get(c)+1);//避免跳过来导致的跳回去
//            }
//            maxLen = Math.max(maxLen, end-front+1);
//            map.put(c,end);
//        }
//
//        return maxLen;
//    }
//}