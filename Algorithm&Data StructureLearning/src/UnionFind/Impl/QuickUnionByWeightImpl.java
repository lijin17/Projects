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
public class QuickUnionByWeightImpl implements IUnionFind {

    int count;//节点个数

    private int[] parents;//节点
    
    private int[] size;//权重

    public QuickUnionByWeightImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.size = new int[count];
        
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;//因为初始化时所有节点都是根节点，所以权重都为1
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
        if (size[xRoot] < size[yRoot]) {
            parents[xRoot] = yRoot;
            size[yRoot] = size[yRoot] + size[xRoot];
        } else {
            parents[yRoot] = xRoot;
            size[xRoot] = size[xRoot] + size[yRoot];
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
