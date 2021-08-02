package leetcode.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Walls {

    //首先解决给定一个起点和终点，
    static int MAX;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] para =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = para[0];
        int col = para[1];

        Character[][] maze = new Character[row][col];
        for (int i = 0; i < row; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                maze[i][j] = s[j].charAt(0);
            }
        }

        int[][] dir = {{0,1},{1,0}};// r, d
        boolean[][] visited = new boolean[row][col];
        MAX = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(maze[i][j] != '#');
                    dfs(maze, visited, i, j, 0, dir);
            }
        }


        System.out.println(MAX);

    }

    static void dfs(Character[][] maze, boolean[][] visited, int x, int y, int max, int[][] dir){


        for (int i = 0; i < dir[0].length; i++) {
            int row = x + dir[i][0];
            int col = y + dir[i][1];

            if (row >= 0 && row < maze.length &&
                    col >= 0 && col < maze[0].length &&
                    !visited[row][col] && maze[row][col] != '#') {
                visited[row][col] = true;

                max++;
                if(max > MAX)
                    MAX = max;
                dfs(maze, visited, row, col, max, dir);
            }
        }


    }

}
