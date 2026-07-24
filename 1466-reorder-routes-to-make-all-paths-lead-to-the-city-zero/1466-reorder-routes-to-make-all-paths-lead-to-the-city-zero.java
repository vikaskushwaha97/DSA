class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            graph[a].add(new int[]{b, 1}); // original direction a->b, costs 1 to reverse
            graph[b].add(new int[]{a, 0}); // reverse direction, already points toward root, costs 0
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int totalCost = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int[] edge : graph[node]) {
                int neighbor = edge[0];
                int cost = edge[1];
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    totalCost += cost;
                    stack.push(neighbor);
                }
            }
        }

        return totalCost;
    }
}