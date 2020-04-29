package oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 一个长方体纸箱由六个面构成。
 *
 * 现在给出六块纸板的长和宽，请你判断能否用这六块纸板构成一个长方体纸箱。
 *
 * 输入
 * 第一行包含一个整数T，表示测试数据组数。
 *
 * 1 <= T <= 10
 *
 * 对于每组测试数据包含六行，每行包含两个整数h, w，表示一块纸板的长和宽。
 *
 * 1 <= h, w <= 1e4
 */
public class Jd1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int volume = Integer.parseInt(in.nextLine());
        for (int t = 0; t < volume; t++) {
            boolean res = false;
            Map<Integer, Integer> map = new HashMap<>();

            int squareNum = 0;
            for (int i = 0; i < 6; i++) {
                String line = in.nextLine();
                String[] str = line.split(" ");
                if (Integer.valueOf(str[0]).equals(Integer.valueOf(str[1]))) {
                    squareNum++;
                }

                Arrays.stream(str).mapToInt(Integer::parseInt).forEach(val->{
                    if (map.containsKey(val)) {
                        map.put(val, map.get(val) + 1);
                    }else{
                        map.put(val, 1);
                    }
                });

            }
            if(map.size() == 1) res = true;

            if(map.size() == 2){
                if(squareNum == 2) res = true;//长宽高只有两种的情况下，正方形木板只能有两个，剩下一个边随意了

            }

            if(map.size() == 3) {
                res = true;
                for (Integer val : map.values()) {
                    if (val != 4) {
                        res = false;
                        break;
                    }
                }
            }

            System.out.println(res == true ? "POSSIBLE": "IMPOSSIBLE");
        }
    }
}