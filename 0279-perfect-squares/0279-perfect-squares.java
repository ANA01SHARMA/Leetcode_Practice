class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        // Initialize with maximum value
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        // Fill DP array
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}