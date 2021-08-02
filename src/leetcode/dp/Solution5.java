package leetcode.dp;

public class Solution5 {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = s.length();
        int maxLen = 1;
        int pos = 0;
        boolean[][] dp = new boolean[len][len];

        for (int delta = 0; delta < len; delta++) {
            for (int row = 0; row < len-delta; row++) {
                int col = row + delta;
                if(delta == 0){
                    dp[row][col] = true;
                }else if(delta == 1){
                    if (str[row] == str[col]) {
                        dp[row][col] = true;
                        maxLen = 2;
                        pos = row;
                    }
                }else{
                    if (dp[row + 1][col - 1] && str[row] == str[col]) {
                        dp[row][col] = true;
                        if(col - row + 1 > maxLen){
                            maxLen = col-row+1;
                            pos = row;
                        }

                    }
                }
            }
        }
        return s.substring(pos,pos+maxLen);
    }

    public String same(String s){
        char[] str = s.toCharArray();
        int maxLen = 1;
        int strLen = s.length();
        boolean[][] dp = new boolean[strLen][strLen];
        int start = 0;

        for (int delta = 0; delta < strLen; delta++) {
            for (int row = 0; row < strLen; row++) {
                int col = row + delta;
                if(delta == 0) dp[row][col] = true;
                else if(delta == 1) {
                    if(dp[row][col] = str[col] == str[row]){
                        start = row;
                        maxLen = 2;
                    }
                }else{
                    if(dp[row + 1][col - 1] && (dp[row][col] = str[col] == str[row])){
                        if(col - row + 1 > maxLen){
                           maxLen = col-row+1;
                           start = row;
                        }
                    }
                }
            }
        }
        return new String(str, start, maxLen);
    }
}
