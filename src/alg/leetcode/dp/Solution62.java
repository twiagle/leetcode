package alg.leetcode.dp;

import java.util.Arrays;

/**
 * dp[i][j] 表示从起点到 (i, j) 的总走法。
 *
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int[] ints : dp) {
            ints[0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
