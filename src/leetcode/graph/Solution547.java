package leetcode.graph;

public class Solution547 {
    public int findCircleNum(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        boolean[] visited = new boolean[row];
        int res = 0;

        for (int i = 0; i < row; i++) {
            if(!visited[i]){
                res++;
                dfs(M, visited, i);
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {

        if (visited[i]) {
            return;
        }

        for (int j = 0; j < M[i].length; j++) {
            if( M[i][j] == 1){
                visited[i] = true;
                dfs(M, visited, j);
            }
        }
    }
}
