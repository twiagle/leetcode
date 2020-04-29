package oj;


/**
 * 不要添加package answer之类的语句
 * Main为唯一的public class,其他用默认
 */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 A、B两伙马贼意外地在一片沙漠中发现了一处金矿，双方都想独占金矿，但各自的实力都不足以吞下对方，经过谈判后，双方同意用一个公平的方式来处理这片金矿。
 处理的规则如下：他们把整个金矿分成n段，由A、B开始轮流从最左端或最右端占据一段，直到分完为止。

 马贼A想提前知道他们能分到多少金子，因此请你帮忙计算他们最后各自拥有多少金子?（两伙马贼均会采取对己方有利的策略）
 */
public class Solution360_2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int groupNum = Integer.parseInt(cin.nextLine());
        int order = 1;
        while (cin.hasNextLine()) {
            int volume = Integer.parseInt(cin.nextLine());

            String line = cin.nextLine();
            String[] str = line.split(" ");
            List<Integer> values = Stream.of(str).map(Integer::parseInt).collect(Collectors.toList());
//            int[] array = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();//展示如何使用array流

            int[][] dp = new int[volume][volume];//给定规模，先手的最优
            int[][] rest = new int[volume][volume];//给定规模，后手拿到的一定是总量减去先手拿到的
            for (int i = 0; i < volume; i++) {
                dp[i][i] = values.get(i);
            }
            for (int i = 0; i < volume - 1; i++) {
                dp[i][i + 1] = Math.max(values.get(i), values.get(i + 1));
            }
            //后手 = 总量 - 最优先手
            for (int i = 0; i < volume - 1; i++) {
                rest[i][i + 1] = values.subList(i, i + 2).stream().reduce(0, Integer::sum) - dp[i][i+1];//endpoint exclusive
            }
            //后手 = 总量 - 最优先手, 先手 = 当前 + 子序列作为后手（后手是子序列的先手，也拿最优, 先手在子序列中是后手，拿剩下的）
            for (int delta = 2; delta < volume; delta++) {
                for (int i = 0; i < volume - delta; i++) {
                    int j = i + delta;
                    dp[i][j] = Math.max(values.get(i) + rest[i + 1][j], values.get(j) + rest[i][j - 1]);

                    rest[i][j] = values.subList(i, j+1).stream().reduce(0, Integer::sum) - dp[i][j];//endpoint exclusive
                    //优化点：总量可以事先计算出来，2-4 就是sum[4] - sum[2]
//                    rest[i][j] = Arrays.stream(array, i, j + 1).sum() - dp[i][j];//array流也可以类似子串

                }
            }
            System.out.println(String.format("Case #%d: %d %d", order++, dp[0][volume - 1], rest[0][volume-1]));

        }
    }
}













