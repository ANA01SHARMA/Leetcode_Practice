class Solution {
    public int findJudge(int n, int[][] trust) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];

        for (int[] edge : trust) {
            int person = edge[0];
            int trustedPerson = edge[1];

            adj.get(person).add(trustedPerson);

            inDegree[trustedPerson]++;
        }

        for (int person = 1; person <= n; person++) {

            boolean trustsNobody = adj.get(person).isEmpty();

            boolean everyoneTrusts = inDegree[person] == n - 1;

            if (trustsNobody && everyoneTrusts) {
                return person;
            }
        }

        return -1;
    }
}