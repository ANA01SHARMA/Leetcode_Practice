import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If start or end cell is blocked, return -1
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // Single cell matrix edge case
        if (n == 1) {
            return 1;
        }

        // All 8 possible movement directions (row, col)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},         { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1; // Mark as visited by mutating grid value (path length = 1)

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = grid[r][c];

            // Reached bottom-right cell
            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check bounds and if cell is valid/unvisited (value is 0)
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = dist + 1; // Mark as visited with updated path length
                }
            }
        }

        return -1;
    }
}