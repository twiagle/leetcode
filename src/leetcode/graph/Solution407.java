package leetcode.graph;

import java.util.PriorityQueue;

/**
 * 对于任意内部位置，可以当作木桶内部，它的四周就是它的木桶
 * 最小堆顶是全局木桶短板，必然是其周围木桶内部的短板
 * 接完雨水之后中心块还要存进队列中，但这时要存入的中心块是接完雨水后的中心块，变成木桶了
 */
class Solution407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>((o1,o2) -> o1.height-o2.height);
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
            visited[i][0] = visited[i][n-1] = true;
        }
        for (int i = 1; i < n-1; i++) {
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
            visited[0][i] = visited[m-1][i] = true;
        }

        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        int max = 0;

        while (!pq.isEmpty()) {//优先队列也是队列，所以也是广度优先遍历！
            Cell cell = pq.poll();
            for (int i = 0; i < dir.length; i++) {

                int row = cell.row + dir[i][0];
                int col = cell.col + dir[i][1];

                if(row >= 0 && row < m &&
                        col >= 0 && col < n &&
                        !visited[row][col]){
                    visited[row][col] = true;
                    max += Math.max(0, cell.height - heightMap[row][col]);
                    pq.offer(new Cell(row, col, Math.max(cell.height,heightMap[row][col])));
                }
            }
        }

        return max;

    }
}

class Cell{
    int row;
    int col;
    int height;

    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}