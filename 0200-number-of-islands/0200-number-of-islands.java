class Solution {

    public void dfs(char[][] grid, int i, int j) {

        // Boundary check
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;

        // Water or already visited
        if (grid[i][j] == '0')
            return;

        // Mark as visited
        grid[i][j] = '0';

        // Visit all 4 directions
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
        dfs(grid, i, j + 1); // Right
    }

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {

                    count++;

                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }
}