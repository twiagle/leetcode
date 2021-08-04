package leetcode;


import leetcode.backtracking.Quanpailie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> permute = Quanpailie.permute(new int[]{1, 2, 3});

        System.out.println(hello());



    }

    static int hello(){

        int i=0;
        try{
            i++;
            return i;
        }finally {
            i++;
        }
    }
}
