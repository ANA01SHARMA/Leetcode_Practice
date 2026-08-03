import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // effort[r][c] stores the minimum effort required to reach cell (r, c)
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        // Min-heap storing {currentEffort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});

        // 4-directional movements: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currEffort = current[0];
            int r = current[1];
            int c = current[2];

            // Reached the destination
            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }

            // Skip if a path with smaller effort to this cell has already been processed
            if (currEffort > effort[r][c]) {
                continue;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundary conditions
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // Maximum height difference along the route to (nr, nc)
                    int nextEffort = Math.max(currEffort, Math.abs(heights[r][c] - heights[nr][nc]));

                    if (nextEffort < effort[nr][nc]) {
                        effort[nr][nc] = nextEffort;
                        pq.offer(new int[]{nextEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}