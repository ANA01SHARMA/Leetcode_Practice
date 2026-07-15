class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];

        for (int[] t : trust) {
            outdeg[t[0]]++;
            indeg[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outdeg[i] == 0 && indeg[i] == n - 1)
                return i;
        }
        return -1;
    }
}