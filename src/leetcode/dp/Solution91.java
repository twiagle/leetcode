package leetcode.dp;

/**
 * 递归是自顶向下的思想
 * 左到右  和右到左  在遍历的角度是等价的（都是自顶向下），只是正确的（简洁的）判断是根据前一位判断
 * (从第一座山开始和从最后一座山开始理论上没区别)
 * 没有简洁的结束条件不是好的递归
 *
 * 从右向左呢？首位为0白算，干脆一开始判断；如果中间出来非法啊字符30，带回去0
 */
public class Solution91 {
    char[] str;
    public int numDecodings(String s) {
        if ("0".equals(s)) {
            return 0;
        }
        str = s.toCharArray();
        return recursive(s.length());
    }

    public int recursive(int cur) {
        if(cur <= 0 ) return 1;//dp[-1]=dp[0] = 1;
        //cur >= 1
        int cnt = 0;
        if(str[cur] > '0') cnt += recursive(cur - 1);//cut = dp[cur-1]
        if(str[cur-1] == '1' || (str[cur-1] == '2' && str[cur] < '7')); cnt+=recursive(cur-2);//10-26//cnt+=dp[cur-2]
        return cnt;
    }
}
//递归从左往右也行！
//        return ways(0);
//                }
//
//public int ways(int cur){
//        if(cur == str.length) return 1;
//        if(str[cur] == '0') return 0;
//        if(mem[cur] != -1) return mem[cur];
//
//        int cnt = 0;
//        cnt += ways(cur + 1);
//        if(str.length - cur >= 2){
//          if (str[cur] == '1' || (str[cur] == '2' && str[cur+1] < '7')) {//10-26
//              cnt += ways(cur + 2);
//          }
//        }
//        mem[cur] = cnt;
//        return cnt;
//        }

//dp第一种递归的自底向上，即从左到右
//class Solution {
//    char[] str;
//    int[] dp;
//    public int numDecodings(String s) {
//        if (s.isEmpty() || s.charAt(0) == '0') {
//            return 0;
//        }
//        str = s.toCharArray();
//        dp = new int[s.length()+1];
//        dp[0] = 1;
//        dp[1] = 1;// str[0]
//
//        for(int i = 1; i<str.length; i++){
//            if(str[i] > '0') dp[i+1] = dp[i];//cut = dp[cur-1]
//            if(str[i-1] == '1' || (str[i-1] == '2' && str[i] < '7')) dp[i+1] += dp[i-1];//10-26//cnt+=dp[cur-2]
//            //对都不合法如 00 或07，记录0，java数组默认0
//        }
//        return dp[s.length()];
//    }
//}

//save space
//class Solution {
//    char[] str;
//    int[] dp;
//    public int numDecodings(String s) {
//        if (s.isEmpty() || s.charAt(0) == '0') {
//            return 0;
//        }
//        if(s.length() == 1) return 1;
//        str = s.toCharArray();
//        dp = new int[2];
//        dp[0] = 1;
//        dp[1] = 1;// str[0]
//
//        for(int i = 1; i<str.length; i++){
//            int w = 0;
//            if(str[i] > '0') w = dp[1];//cut = dp[cur-1]
//            if(str[i-1] == '1' || (str[i-1] == '2' && str[i] < '7')) w += dp[0];//10-26//cnt+=dp[cur-2]
//            //对都不合法如 00 或07，w=0
//            dp[0] = dp[1];
//            dp[1] = w;
//        }
//        return dp[1];
//    }
//}