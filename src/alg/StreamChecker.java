package alg;

class StreamChecker {
    private TrieNode root = new TrieNode('/'); // 存储无意义字符
    private char[] deque = new char[40005];
    private int index = 0;
    int maxLen = 0;

    public StreamChecker(String[] words) {
        for(String word : words){
            char[] cs =  new char[word.length()];
            for(int i=0;i<word.length();i++){
                cs[i] = word.charAt(word.length()-1-i);
            }
            maxLen = word.length() > maxLen ? word.length() : maxLen;
            insert(cs);
        }
    }

    public boolean query(char letter) {
        deque[index++] = letter;
        int t = index-1;

        TrieNode p = root;
        for (int i = 0; i < maxLen; ++i) {
            if(t>=0){
                int index = deque[t--] - 'a';
                if (p.children[index] != null) {
                    p = p.children[index];
                    if (p.isEndingChar == true) return true; // 不能完全匹配，只是前缀
                }else{
                    return false;
                }
            }
        }
        return false;
    }




    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }


    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }
}