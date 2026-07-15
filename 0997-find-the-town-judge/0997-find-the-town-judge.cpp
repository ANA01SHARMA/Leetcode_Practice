class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust)
    {
        vector <int> degree(n+1, 0);

        vector <vector <int>> graph(n+1);

        for (auto &t : trust)
        {
            graph[t[0]].push_back(t[1]);

            degree[t[1]] ++;
        }

        for (int node = 1; node <= n; node ++)
        {
            if (graph[node].empty() and degree[node] == n-1)
            {
                return node;
            }
        }

        return -1;
    }
};