package leetcode.tree;

import java.util.*;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 */
public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TireNode root = new TireNode();
        for (int i = 0; i < words.length; i++) {
            addStr(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            match(root, words[i], i, res);
        }

        return res;
    }

    private void match(TireNode root, String word, int index, List<List<Integer>> res) {

        char[] chars = word.toCharArray();
        for (int j = 0; j < word.length(); j++) {//k1 alive

            if(root.index != -1 && root.index != index){//k1 < k2
                if (isPalindrome(word, j, word.length() - 1)) {
                    res.add(Arrays.asList(index,root.index));
                }
            }

            if (!root.children.containsKey(chars[j])) {//fail fast
                return;
            }

            root = root.children.get(chars[j]);
            // if k1 k2一样长且相等，开始的时候就导出了
            if(root == null) return;
        }
        // k1 == k2  k1 < k2
        for(int treeIndex:  root.palindromes){
            if(index==treeIndex) continue;;
            res.add(Arrays.asList(index,treeIndex));// 这俩位置不能变呀，一个开头，一个结尾，反了就不对了
        }
    }


    private void addStr(TireNode root, String word, int index) {
        char[] chars = word.toCharArray();
        for (int j=word.length()-1; j>=0; j--) {
            root.children.putIfAbsent(chars[j], new TireNode());
            //判断 这个字符串 当前儿子是否自身回文
            if(isPalindrome(word, 0, j)){
                root.palindromes.add(index);
            }
            root = root.children.get(chars[j]);

        }
        //树最后一个字符，也是字符串第一个字符
        //单字符本身就是回文   这里同一了，match的时候就不用再判当前是否结束了
        //word == ""就在root直接做结尾，空串就是index
            root.palindromes.add(index);
            root.index = index;

    }

    /**
     * 一前一后再写成两个++ 我就，我有点急事！
     * @param s
     * @param from
     * @param to
     * @return
     */
    public boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if(s.charAt(from++) != s.charAt(to--)) return false;
        }
        return true;
    }
}

//我（k1 长度=k2）以及我以后(k1 < k2)的树上仍是回文的index
class TireNode{//值 在父亲 map 的key
    int index;//不是结尾-1， 是结尾  字符串下标
    List<Integer> palindromes;//该节点往下能构成的字符串是回文的  字符串下标
    Map<Character, TireNode> children;

    TireNode(){
        index = -1;
        palindromes = new ArrayList<>();
        children = new HashMap<>();
    }
}
