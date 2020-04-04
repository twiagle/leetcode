package alg.leetcode.arraylist;
/**
 * LeetCode 11. Container With Most Water
 * skill: two pointer, greedy
 * s = length * height
 * decrease length while using greater height, find most space for each length
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int max=0;
        int left=0, right=height.length-1;

        while (left < right) {
            int cur = (right - left) * Math.min(height[left], height[right]);
            max = max > cur ? max : cur;
            if (height[left] >= height[right]) {
                right--;
            }else{
                left++;
            }
        }

        return max;
    }
}
