package oj;


/**
 * 不要添加package answer之类的语句
 * Main为唯一的public class,其他用默认
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小B的目的很简单:控制服务器的内存区域，试图在内存中装入从1到n之间的n个自然数，以覆盖内存区域。可能是小B对编程理解上的问题，病毒似乎没有完全成功。
 * 可能是由于保护机制的原因，内存写入只接受二进制的形式，所以十进制表达中除0和1之外的其他值都没有成功写入内存。
 * 小B希望知道，究竟有多少数成功的写入了服务器的内存！
 */
public class Solution360_0 {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);

        while(cin.hasNextInt())
        {
            String a = cin.next();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) > '1'){
                    char[] str = new char[a.length()-i];
                    Arrays.fill(str, '1');
                    b.append(str);
                    break;
                }else if(a.charAt(i) == '1')
                    b.append('1');
                else b.append('0');
            }
            long cnt=0;
            for (int i = 0; i < b.length(); i++) {
                if(b.charAt(i)=='1'){
                    cnt += (long) Math.pow(2, b.length() - i - 1);
                }
            }

            System.out.println(cnt);
        }
    }
}
