package swordOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public class Solution {
        public boolean Find(int target, int [][] array) {
            if(array.length == 0 || array[0].length == 0){
                return false;
            }
            int i=array.length-1, j=0;
            while(i>=0 && j<array.length){
                int t = array[i][j];
                if(t == target){
                    return true;
                }else if(t > target){
                    i--;
                }else{
                    j++;
                }
            }
            return false;

        }
    }
}
