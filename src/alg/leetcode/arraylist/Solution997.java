package alg.leetcode.arraylist;

/**
 *977. 有序数组的平方
 */
public class Solution997 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int l=0, r=A.length-1;
        int resPos= r;
        while (l <= r) {
            int lSquare = A[l]*A[l];
            int rSquare = A[r]*A[r];
            int max = Math.max(lSquare, rSquare);
            res[resPos--] = max;
            if (max == lSquare) {
                l++;
            } else if (max == rSquare) {
                r--;
            }
        }
        return res;
    }




}
