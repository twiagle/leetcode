package alg.leetcode.arraylist;


/**
 * 917. 仅仅反转字母
 */
public class Solution917 {
    public static String reverseOnlyLetters(String S) {
        char[] str = S.toCharArray();
        char[] res = new char[str.length];
        int l=0, r=str.length-1;

        while (l>=0 && l <= r) {
            if(!Character.isLetter(str[l])) {
                res[l] = str[l];
                l++;
                continue;
            }
            if(!Character.isLetter(str[r])) {
                res[r] = str[r];
                r--;
                continue;
            }
            res[l] = str[r];//cannot r++, will effect next line code
            res[r] = str[l];
            l++;
            r--;
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bc-def-high"));
    }
}
