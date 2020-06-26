package leetcode.dp;

public class Solution42 {
    public int trap(int[] height) {
        int len = height.length;
        int[][] dp = new int[height.length][2];
        int lMax = 0, rMax = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i][0] = lMax;
            if(height[i] > lMax) lMax = height[i];
            dp[len-1-i][1] = rMax;
            if(height[len-1-i] > rMax) rMax = height[len-1-i];
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, (Math.min(dp[i][0], dp[i][1]) - height[i]));
        }

        return res;
    }

    //双指针
    //从左往右处理到left下标时，左边的最大值left_max对它而言是可信的
//对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
//这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。

//    public int trap(int[] height) {
//        int len = height.length;
//        int lCur = 0, rCur = len-1;
//        int lMax = 0, rMax = 0;
//        int res = 0;
//        while(lCur <= rCur){
//            if(lMax <= rMax){
//                res += Math.max(0,Math.min(lMax,rMax)-height[lCur]);
//                if(height[lCur] > lMax) lMax = height[lCur];
//                lCur++;
//            }else{
//                res += Math.max(0,Math.min(lMax,rMax)-height[rCur]);
//                if(height[rCur] > rMax) rMax = height[rCur];
//                rCur--;
//            }
//        }
//        return res;
//    }
}
