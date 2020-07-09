package leetcode.graph;

//把边依次union，返回第一次发现的union失败的边,
public class Solution684 {
    static class DSU{
        int[] parent;
        int[] size ;//初始都是0咯
        public DSU(int n){
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;//self is father, cannot fill -1 as same father
            }
        }
        public int find(int x){
            //path compression
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int[] edge){
            int rootX = find(edge[0]);
            int rootY = find(edge[1]);
            if(rootX == rootY) return false;

            if(size[rootX] >= size[rootY]){
                parent[rootY] = rootX;
                size[rootX]++;
            }else{
                parent[rootX] = rootY;
                size[rootY]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length +1);//edge start from 1, cant use 0
        for (int i = 0; i < edges.length; i++) {
            if (!dsu.union(edges[i])) {
                return edges[i];
            }
        }
        return new int[0];
    }
}
