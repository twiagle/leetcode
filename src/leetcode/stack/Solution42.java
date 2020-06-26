package leetcode.stack;

public class Solution42 {

    public int trap(int[] height) {
        int len = height.length;
        int lCur = 0, rCur = len-1;
        int lMax = 0, rMax = 0;
        int res = 0;
        while(lCur <= rCur){
            if(lMax <= rMax){
                res += Math.max(0,Math.min(lMax,rMax)-height[lCur]);
                if(height[lCur] > lMax) lMax = height[lCur];
                lCur++;
            }else{
                res += Math.max(0,Math.min(lMax,rMax)-height[rCur]);
                if(height[rCur] > rMax) rMax = height[rCur];
                rCur--;
            }
        }
        return res;
    }
}
