import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Adjacency lists for red and blue edges
        List<Integer>[] redAdj = new ArrayList[n];
        List<Integer>[] blueAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }
        
        // Fill the adjacency lists
        for (int[] edge : redEdges) {
            redAdj[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueAdj[edge[0]].add(edge[1]);
        }
        
        // Result array
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        // Queue for BFS: stores (node, length, last color used)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, -1}); // Start with node 0, length 0, no color
        
        boolean[][] visited = new boolean[n][2]; // visited[node][0] for red, visited[node][1] for blue
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int length = current[1];
            int lastColor = current[2];
            
            // If this is the first time visiting the node, update the result
            if (res[node] == -1) {
                res[node] = length;
            }
            
            // Explore neighbors with alternating color
            if (lastColor != 0) { // If last was not red, explore red edges
                for (int neighbor : redAdj[node]) {
                    if (!visited[neighbor][0]) {
                        visited[neighbor][0] = true;
                        queue.offer(new int[]{neighbor, length + 1, 0});
                    }
                }
            }
            if (lastColor != 1) { // If last was not blue, explore blue edges
                for (int neighbor : blueAdj[node]) {
                    if (!visited[neighbor][1]) {
                        visited[neighbor][1] = true;
                        queue.offer(new int[]{neighbor, length + 1, 1});
                    }
                }
            }
        }
        
        return res;
    }
}
