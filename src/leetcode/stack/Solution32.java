package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 比标准栈的解法用的空间多，我这里没有淘汰没用的右括号，而是把右括号代表的配不了对的位置压入，永远只取最高的
 * 如果是左括号，那么以当前为结束的最长的已经匹配的子串起点就是直到前一个右括号，
 * -1只有一个作用，就是假装作为右括号（不匹配点），()  1-(-1) 就是长度2
 */
public class Solution32 {
    public static int longestValidParentheses(String s) {
        int max = 0;
        char[] str = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == '(') {
                stack.push(i);
            }else {
                int t = stack.peek();
                if(t != -1 && str[t] == '('){
                    stack.pop();
                    max = Math.max(i - stack.peek(), max);
                }else{
                    stack.push(i);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        longestValidParentheses(")()())");
    }
}
/**
 * 标准解法优化了没用的右括号，发现是右括号则弹出旧的，又不能空了，还需要记录上一个不匹配点，所以至少保留一个右括号
 */
//public class Solution {
//
//    public int longestValidParentheses(String s) {
//        int maxans = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.empty()) {
//                    stack.push(i);
//                } else {
//                    maxans = Math.max(maxans, i - stack.peek());
//                }
//            }
//        }
//        return maxans;
//    }
//}
