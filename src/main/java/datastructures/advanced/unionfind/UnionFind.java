package datastructures.advanced.unionfind;

import algorithms.utils.ArrayUtils;

public class UnionFind {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(5);
        unionFind.union(2, 4);
        System.out.println(unionFind.count);
        System.out.println(unionFind.connected(1, 4));
        System.out.println(unionFind.connected(2, 4));

        int[][] connections = {
                {4, 3},
                {3, 8},
                {6, 5},
                {9, 4},
                {2, 1},
                {8, 9},
                {5, 0},
                {7, 2},
                {6, 1},
                {1, 0},
                {6, 7}
        };
        UnionFind unionFind1 = new UnionFind(10);
        for (int[] connection : connections) {
            unionFind1.union(connection[0], connection[1]);
            ArrayUtils.printArray(unionFind1.parent);
        }
        System.out.println(unionFind1.count + " components");
    }

    // 记录连通分量
    private int count;
    // 节点 x 的节点是 parent[x]
    private int[] parent;
    private int[] size;

    /* 构造函数，n 为图的节点总数 */
    public UnionFind(int n) {
        // 一开始互不连通
        this.count = n;
        // 父节点指针初始指向自己
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }


    /* 将 p 和 q 连接 */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] >= size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /* 判断 p 和 q 是否连通 */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /* 返回图中有多少个连通分量 */
    public int count() {
        return count;
    }

    /* 返回某个节点 x 的根节点 */
    private int find(int x) {
        // 根节点的 parent[x] == x
        while (parent[x] != x) {
            // path compression
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
