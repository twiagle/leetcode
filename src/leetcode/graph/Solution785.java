package leetcode.graph;

/**
 * 判断二分图：初始全0, 画笔1，-1交替，不同颜色说明不是二分图
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int[] vistied = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vistied[i] == 0 && !dfs(graph, vistied, i, 1)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int[] visited, int cur, int tarColor) {
        //跳过已经访问过的节点
        if (visited[cur] != 0) {
            return visited[cur] == tarColor;
        }
        visited[cur]=tarColor;
        for (int i = 0; i < graph[cur].length; i++) {
            if( !dfs(graph, visited, graph[cur][i], -tarColor))
                return false;
        }
        return true;
    }

}
