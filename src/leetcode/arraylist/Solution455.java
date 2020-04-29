package leetcode.arraylist;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * skill: double pointer, greedy
 * bigger biscuits fit bigger appetite, same lose for current biscuit, so smaller biscuit may fit smaller appetite
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int res=0;
        int gPos = g.length-1;
        int sPos = s.length-1;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gPos >=0 && sPos >=0) {
            if (s[sPos] >= g[gPos]) {
                res++;
                gPos--;
                sPos--;
            }else{
                gPos--;
            }
        }
        return res;
    }
}
