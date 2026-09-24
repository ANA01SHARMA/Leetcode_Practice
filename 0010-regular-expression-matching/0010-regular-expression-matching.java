class Solution {

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return match(0, 0, s, p, dp);
    }

    private boolean match(int i, int j, String s, String p, Boolean[][] dp) {

        if (dp[i][j] != null)
            return dp[i][j];

        // pattern finished
        if (j == p.length())
            return dp[i][j] = (i == s.length());

        boolean firstMatch =
                (i < s.length()) &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // check '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            dp[i][j] =
                    match(i, j + 2, s, p, dp) ||      // ignore x*
                    (firstMatch && match(i + 1, j, s, p, dp)); // use *

        } else {

            dp[i][j] =
                    firstMatch && match(i + 1, j + 1, s, p, dp);
        }

        return dp[i][j];
    }
}