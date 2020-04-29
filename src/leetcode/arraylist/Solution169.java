package leetcode.arraylist;

import java.util.Arrays;

/**
 * 169. 多数元素,求众数
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
