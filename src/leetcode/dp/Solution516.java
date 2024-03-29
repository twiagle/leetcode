package leetcode.dp;

/**
 * 只有一个的时候长度1
 * 只有两个的时候，是回文或者不是回文
 * 三个，中间（除去最外）是不是回文（当场判断），不是的话左边两个，右边两个（两个规模的时候判断，现在直接用结果）
 * dp的正确性就是从小到大推导的时候保证的
 * 多阶段决策放到二维里面有点像多规模决策
 *
 *
 */
public class Solution516 {
    public static int longestPalindromeSubseq(String s) {
        if(s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=1;
        }
        for (int delta = 1; delta < s.length(); delta++) {
            for (int i = 0; i < s.length() - delta; i++) {
                int j = i + delta;
                if(str[i]==str[j]){
                    dp[i][j] = delta == 1 ? 2 : dp[i+1][j-1] + 2;//初始2个时，回文成功为2
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        longestPalindromeSubseq("bbbab");
    }
//楼上太简化了，合并了很多条件反而看不清
    class Solution {
        public int longestPalindromeSubseq(String s) {
            if("".equals(s)) return 0;

            char[] str = s.toCharArray();
            int strLen = s.length();
            int[][] dp = new int[strLen][strLen];

            for (int delta = 0; delta < strLen; delta++) {
                for (int row = 0; row < strLen-delta; row++) {
                    int col = row + delta;
                    if(delta == 0) dp[row][col] = 1;
                    else if(delta == 1){
                        if(str[col] == str[row]){
                            dp[row][col] = 2;
                        }else
                            dp[row][col] = 1;
                    }else{
                        if(str[col] == str[row]){
                            dp[row][col] = dp[row+1][col-1]+2;//向里缩
                        }else{
                            dp[row][col] = Math.max(dp[row+1][col], dp[row][col-1]);
                        }
                    }
                }
            }
            return dp[0][strLen-1];
        }
    }
}
