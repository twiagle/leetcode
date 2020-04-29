package leetcode.dp;

/**
 * 经典的 0-1 思想，简单说就是：“选还是不选”。
 *
 * 假设 dp[i] 表示到第 i 个元素为止我们所能收获到的最大总数。
 */
public class Solution198 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
