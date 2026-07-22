class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int neighbor : adj.get(node)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}