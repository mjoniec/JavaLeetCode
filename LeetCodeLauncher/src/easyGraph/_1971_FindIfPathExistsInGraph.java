package easyGraph;

import java.util.*;

public class _1971_FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1) return true;

        //graph - each node has a set of all edges
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        //start of BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        //prevents endless cycle
        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            var connections = graph.getOrDefault(node, new HashSet<>());

            if(connections.contains(destination)) return true;

            visited.add(node);

            for(Integer c : connections){
                if(!visited.contains(c)) queue.add(c);
            }
        }

        return false;
    }

    public void run() {
        System.out.println("_1971_FindIfPathExistsInGraph: ");
        System.out.println("Expected true   Actual: "
                + validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println("Expected false   Actual: "
                + validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }
}
