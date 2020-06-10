package leetcode.string;

public class Solution44 {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
             return false;
        }
        return isMatch(s, s.length() - 1, p, p.length() - 1);

    }
    //. or z-a
    public static boolean isMatch(char s, char p) {
        return s == p || p == '.';
    }

    public static boolean isMatch(String s, int i, String p, int j) {
        //end
        if (i == 0 ) {
            if((j==1 && p.charAt(j) == '*') || (j==0 && s.charAt(0)==p.charAt(0))) return true;
            else return isMatch(s,0,p,j-2);
        }else{
            if(p.charAt(j) == '*'){
                return isMatch(p.charAt(j - 1), s.charAt(i)) && isMatch(s, i - 1, p, j) || isMatch(s, i, p, j - 2);
            }else{
                return isMatch(s.charAt(i), p.charAt(j)) && isMatch(s, i - 1, p, j - 1);
            }
        }
    }

    public static void main(String[] args) {

        boolean b = isMatch("aaab", "a*b");
        System.out.println(b);
    }
}
