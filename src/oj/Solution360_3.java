package oj;


/**
 * 不要添加package answer之类的语句
 * Main为唯一的public class,其他用默认
 */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 最强的不一定是最后的赢家。
 * 某赛事有n名选手参加，但是不同于其他的比赛，本比赛采取的是擂台赛的形式，n名选手排成一排，每次队伍的第一位和第二位选手进行比赛，输的一方会排到队尾。
 * 当某位选手取得m连胜时，他将成为最后的赢家，且游戏结束，请问截止到游戏结束，共会进行多少次比赛。
 * 两位选手的比赛结果由他们的战斗力决定，n位选手的战斗力是一个1~n的排列，也就是说他们的战斗力两两不同，不会有平局的情况。
 *
 * 给定一个数a0，定义如下随机序列a1,a2,...an。
 * 1、从闭区间[0,a0]中等概率随机选出一个整数k0，令a1=a0-k0。
 * 2、得到随机数a1之后，再从闭区间[0,a1]中等概率随机选出一个整数k1，再令 a2=a1-k1。
 * 3、一般地，得到随机数ai之后，再从闭区间[0,ai]中等概率随机选出一个整数ki，令ai+1=ai-ki。
 * 问an=0的概率是多少?
 */
//
//
//
//import java.util.*;
//        import java.util.stream.Stream;
//
///**
// 最强的不一定是最后的赢家。
//
// 某赛事有n名选手参加，但是不同于其他的比赛，本比赛采取的是擂台赛的形式，n名选手排成一排，每次队伍的第一位和第二位选手进行比赛，输的一方会排到队尾。
//
// 当某位选手取得m连胜时，他将成为最后的赢家，且游戏结束，请问截止到游戏结束，共会进行多少次比赛。
//
// 两位选手的比赛结果由他们的战斗力决定，n位选手的战斗力是一个1~n的排列，也就是说他们的战斗力两两不同，不会有平局的情况。
// */
public class Solution360_3{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);

        String line = cin.nextLine();
        String[] str = line.split(" ");
        int[] integers = Stream.of(str).mapToInt(Integer::valueOf).toArray();
        int len = integers[0], target = integers[1];
        line = cin.nextLine();
        str = line.split(" ");

        Deque<Integer> deque = new ArrayDeque<>(len);
        for (String s : str) {
            deque.offerLast(Integer.valueOf(s));
        }

        int winRound=0, totalRound=0;

        int l = deque.pollFirst();
        while (winRound < target) {
            totalRound++;
            int r = deque.pollFirst();
            if (l > r) {
                winRound++;
                deque.offerLast(r);
            }else{
                winRound = 1;
                deque.offerLast(l);
                l=r;
            }
        }


        System.out.println(totalRound);

    }
}






