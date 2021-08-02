package leetcode.string;

public class Solution8 {
    public int myAtoi(String str) {

        int sign = 1;
        long sum = 0;
        int index = 0;
        str = str.trim();
        if(str == null || "".equals(str)) return 0;
        if(str.charAt(0) == '-'){
            sign = -1;
            index++;
        }else if(!Character.isDigit(str.charAt(0))){
            if(str.charAt(0) == '+'){
                index++;
            }else
                return 0;
        }
        //以下都为正
        for(int i=index;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return (int) (sign * sum);
            }
            sum = sum * 10 + str.charAt(i)-'0';
            if(sign == 1 && sum >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && -sum <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }



        return (int) (sign * sum);
    }
}
