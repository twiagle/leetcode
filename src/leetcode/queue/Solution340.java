package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
            Deque<Character> deque = new ArrayDeque<>();
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int max = 0;
//        int slow = 0;
            for (int i = 0; i < chars.length; i++) {
                while(map.size()>k){
                    Character c = deque.poll();
                    int cnt = 0;
                    if((cnt = map.get(c)) >1){
                        map.put(c, --cnt);
                    }else{
                        map.remove(c);
                        break;
                    }
                }
                deque.offer(chars[i]);
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
                if (map.size() <= k) {
                    max = Math.max(max, deque.size());
                }
            }
            return max;
        }
}