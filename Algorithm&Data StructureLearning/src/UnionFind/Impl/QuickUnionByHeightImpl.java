/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnionFind.Impl;

import UnionFind.IUnionFind;

/**
 *
 * @author lijin
 */
public class QuickUnionByHeightImpl implements IUnionFind {

    int count;//节点个数

    private int[] parents;//节点
    
    private int[] rank;//高度排名

    public QuickUnionByHeightImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.rank = new int[count];
        
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;//因为初始化时所有节点都是根节点，所以高度都是1；
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parents[xRoot] = yRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            parents[yRoot] = xRoot;
        } else {
            parents[xRoot] = xRoot;
            rank[xRoot]++;//此处要搞清楚为什么在高度相同的时候要加一
        }
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}
