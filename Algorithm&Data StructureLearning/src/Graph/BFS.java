/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author lijin
 */
public class BFS {

    public static void bfs(GraphNode node) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);//**
        visited.add(node);//**

        while (!queue.isEmpty()) {
            GraphNode n = queue.poll();
            for (GraphNode gn : n.neighbors) {
                if (!visited.contains(gn)) {
                    queue.offer(gn);
                    visited.add(gn);
                }
            }
        }
    }

    public static void bfs2(GraphNode node) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);//**
        visited.add(node);//**

        while (!queue.isEmpty()) {
            int size = queue.size();          
            for (int i = 0; i < size; i++) {
                GraphNode n = queue.poll();
                for (GraphNode gn : n.neighbors) {
                    if (!visited.contains(gn)) {
                        queue.offer(gn);
                        visited.add(gn);
                    }
                }
            }
        }
    }
}
