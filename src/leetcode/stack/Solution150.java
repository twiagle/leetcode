package leetcode.stack;

import java.util.*;

public class Solution150 {
    public static int evalRPN(String[] tokens) {


        Map<Character,Calculator> calculator = new HashMap<>();
        calculator.put('+', Calculator.ADDITION);
        calculator.put('-', Calculator.SUBTRACTION);
        calculator.put('*', Calculator.MULTIPLICATION);
        calculator.put('/', Calculator.DIVISION);


        Deque<Integer> stack = new ArrayDeque<>();
        int result=0;
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0)) || ('-'==token.charAt(0)&&token.length()>1)) {
                stack.push(Integer.valueOf(token));
            }else{
                Character op = token.charAt(0);
                int right = stack.pop();
                int left = stack.pop();
                int res = calculator.get(op).execute(left,right);
                stack.push(res);
            }
        }
        result = stack.pop();


        return result;
    }

    enum Calculator{
        ADDITION{
            @Override
            int execute(int l, int r) {
                return l+r;
            }
        },
        SUBTRACTION{
            @Override
            int execute(int l, int r) {
                return l-r;
            }
        },
        MULTIPLICATION{
            @Override
            int execute(int l, int r) {
                return l*r;
            }
        },
        DIVISION{
            @Override
            int execute(int l, int r) {
                return l/r;
            }
        };

        abstract int execute(int l, int r);
    }


    public static void main(String[] args) {
        evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }
}
