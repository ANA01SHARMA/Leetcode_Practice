class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    void dfs(int[][] img, int r, int c, int oldColor, int newColor) {
        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length)
            return;
        if (img[r][c] != oldColor) return;

        img[r][c] = newColor;
        dfs(img, r + 1, c, oldColor, newColor);
        dfs(img, r - 1, c, oldColor, newColor);
        dfs(img, r, c + 1, oldColor, newColor);
        dfs(img, r, c - 1, oldColor, newColor);
    }
}