package alg.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution51 {
    Integer[] state;
    int order;
    List<List<Integer>> res = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        state = new Integer[n];
        order = n;
        backTracking(0);
        for(List l : res){
            List<String> q = new ArrayList<>(n);
            Integer[] pos = (Integer[])l.toArray(new Integer[0]);
            char[][] queen = new char[n][n];
            for(int i = 0;i<n;i++){
                Arrays.fill(queen[i],'.');
                queen[i][pos[i]] = 'Q';
            }
            for(int i = 0;i<n;i++){
                q.add(String.valueOf(queen[i]));
            }
            result.add(q);
        }
        return result;
    }

    public void backTracking(int row){
        if(row == order){//成功到达
            res.add(Arrays.asList(state.clone()));//java array stores in heep, and collection just store ref
            return;//you can go inside asList->new ArrayList<E[]>(),use same ref with parameter
        }

        for(int i=0; i<order; i++){
            if(isValidate(row, i)){//只走可能成功的儿子
                state[row] = i;
                backTracking(row+1);
            }
        }
    }



    public boolean isValidate(int row, int col){
        for(int i = 0; i< row; i++){
            if((col == state[i]) || Math.abs(row - i) == Math.abs(col-state[i]))
                return false;
        }
        return true;
    }

}
/**
 * 前边是以行为单位，另一种以点为单位
 */
//class Solution {
//    List<List<Integer>> result = new ArrayList<>();
//    int scale;
//    Integer[] queenPos;//Queen position for each row
//
//    public List<List<String>> solveNQueens(int n) {
//        scale = n;
//        queenPos = new Integer[n];
//        for(int i=0; i<scale; i++){
//            backTracking(0, i);
//        }
//
//        List<List<String>> r = new ArrayList<>();
//        for(List l : result){
//            List<String> ls = new ArrayList<>();
//            for(Object i : l){
//                char[] c = new char[scale];
//                Arrays.fill(c, '.');
//                c[(Integer)i] = 'Q';
//                ls.add(String.valueOf(c));
//            }
//            r.add(ls);
//        }
//        return r;
//    }
//    public boolean isValid(int row, int col){
//        for(int i=0; i<row; i++){
//            if(col== queenPos[i] || (row-i)== Math.abs(col-queenPos[i])) return false;
//        }
//        return true;
//    }
//    public void backTracking(int row, int col){
//        //match
//        if(row == scale && col == 0) {//only once
//            result.add(Arrays.asList(queenPos.clone()));
//            return;
//        }//成功到达
//        //self judge
//        if(isValid(row, col) == false) return;//失败止损
//        else{//没成功也没失败
//            queenPos[row] = col;      //先序遍历
//            for(int i=0; i<scale; i++){
//                backTracking(row+1, i);
//            }
//        }
//    }
//}