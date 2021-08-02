package zuochengyun.chap1_stack_queue;

import java.util.HashMap;
import java.util.Map;

public class Solutionxx {

    static int res;
    public static int split_package (String[] filenames, String[][] relations) {

        res = 0;
        int[] visited = new int[filenames.length];
        Map<String, Integer> map = new HashMap<>();
        int[][] graph = new int[filenames.length][filenames.length];
        // write code here
        for (int i = 0; i < filenames.length; i++) {
            map.put(filenames[i], i);
        }
        for (int i = 0; i < relations.length; i++) {
            int from = map.get(relations[i][1]);
            int to = map.get(relations[i][0]);
            graph[to][from] = 1;
        }
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[0].length; j++) {
//                System.out.print(graph[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = 0; i < visited.length; i++) {
            dfs(graph, visited, i);
        }

        return res;
    }

    public static void dfs(int[][] graph, int[] visited, int cur){
        if(visited[cur] == 1) return;
        visited[cur] = 1;
        int flag = 1;
        for (int i = 0; i < graph[cur].length; i++) {
            if(graph[cur][i] == 1){

                flag = 0;
                dfs(graph, visited, i);
            }
        }
        if(flag == 1)
            res++;
    }


    public static void main(String[] args) {
        String[] filenames = {"fileA", "fileB", "fileC", "fileD", "fileE", "fileF", "fileG"};
        String[][] ralations = {{"fileA", "fileB"}, {"fileB", "fileC"}, {"fileD", "fileE"},{"fileF","fileG"}};

        System.out.println(split_package(filenames, ralations));
    }
}
