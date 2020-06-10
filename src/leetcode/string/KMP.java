package leetcode.string;

public class KMP {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(n==0) return 0;
        int i=0,j=0;
        int[] LPS = getLPS(needle);
        while (i < n) {

            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == m){
                    return i-m;
                }
            }else if (j>0){
                j = LPS[j-1];
            }else if(j==0){
                i++;
            }

        }
        return -1;
    }
    public static int[] getLPS(String needle){
        int len =0;//最长公共前后缀
        int i = 1;//结尾位置
        int[] LPS = new int[needle.length()];
        //LPS[0]=0
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                LPS[i++] = ++len;//最长公共前后缀，包含自己
            }else if(len > 0){
                len = LPS[len-1];
            }else if(len==0){
                i++;//LPS[i] == 0;
            }
        }
        return LPS;
    }

    public static void main(String[] args) {
        int i = strStr("abababc", "ababc");
        System.out.println(i);
    }
}
