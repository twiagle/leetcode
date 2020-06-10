package leetcode.stack;

import java.util.*;

/**
 * static result 在leetcode平台上多个测试用例会共享，所以以后全局不要写static
 */
public class Solution22 {
    List<String> result = new ArrayList<>();
    StringBuilder stack = new StringBuilder();
    public  List<String> generateParenthesis(int n) {
        recur(0,0,n);
        return result;
    }

    private void recur(int l, int r, int n) {
        if(l==n && r==n){
            result.add('"'+stack.toString()+'"');
            return;
        }
        if(l > n) return;
        if(r > l) return;
        stack.append("(");
        recur(l + 1, r, n);
        stack.deleteCharAt(stack.length()-1);
        stack.append(")");
        recur(l , r+1, n);
        stack.deleteCharAt(stack.length()-1);
    }
}
