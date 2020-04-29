package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

//hashmap减少if-else
//左入栈，右出栈，字符串结束，栈为空则全部匹配
public class Solution20 {
    static HashMap<Character, Character> map;
    static {
        map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (Character c: s.toCharArray()) {//fori的话可以break奇数个字符的情况
            if (map.containsKey(c)) {
                if(!stack.isEmpty() && map.get(c).equals(stack.pop())){
                    continue;
                }
                return false;
            }else{
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}



//class Solution {
//    public boolean isValid(String s) {
//        char[] str = s.toCharArray();
//        ArrayDeque<Character> stack = new ArrayDeque<>();
//        for(int i=0; i<str.length; i++){
//            if(str[i] == '(' || str[i] == '[' || str[i] == '{' )
//                stack.push(str[i]);
//            else if (str[i] == ')')
//            {   if(stack.isEmpty())return false;
//                if(!stack.isEmpty() && stack.poll() != '(') return false;}
//            else if (str[i] == ']')
//            {if(stack.isEmpty())return false;
//                if(!stack.isEmpty() && stack.poll() != '[') return false;}
//            else if (str[i] == '}')
//            {if(stack.isEmpty())return false;
//                if(!stack.isEmpty() && stack.poll() != '{') return false;}
//        }
//        if(!stack.isEmpty())
//            return false;
//        return true;
//    }
//
//}