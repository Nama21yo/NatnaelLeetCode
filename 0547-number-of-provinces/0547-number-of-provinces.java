
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of provinces
        boolean[] visited = new boolean[n];
        int count = 0; // Number of connected components (provinces)

        // Iterate over each province
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Start a BFS from this node
                bfs(isConnected, visited, i);
                count++; // Each BFS call represents a new connected component
            }
        }

        return count;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            // Check all adjacent nodes
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
