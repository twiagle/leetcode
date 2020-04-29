package leetcode.dp;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];//以当前元素结尾得出的最长上升子序列长度
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int curMax=1;
            for (int j = 0; j < i; j++) {
                //若 nums[j] < nums[i]，说明 nums[i] 有机会构成上升序列，若新的上升序列比之前计算过的还要长，更新一下，保存到 cache 数组
                if (nums[j] < nums[i] && dp[j]+1 > curMax) {
                    curMax = dp[j]+1;
                }
            }
            dp[i] = curMax;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
