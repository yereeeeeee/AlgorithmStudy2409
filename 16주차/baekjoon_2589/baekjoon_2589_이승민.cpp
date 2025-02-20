#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int n, m;
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };
vector<vector<bool>> map;

void init() {
    cin >> n >> m;
    map.resize(n, vector<bool>(m, false));
    for (int i = 0; i < n; ++i) {
        string input;
        cin >> input;
        for (int j = 0; j < m; ++j) {
            if (input[j] == 'L') map[i][j] = true;
        }
    }
}

bool range(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
}

int bfs(int startY, int startX) {
    vector<vector<int>> dist(n, vector<int>(m, -1));
    queue<pair<int, int>> q;
    q.push({ startY, startX });
    dist[startY][startX] = 0;
    int maxDist = 0;

    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for (int d = 0; d < 4; ++d) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (range(nx, ny) && map[ny][nx] && dist[ny][nx] == -1) {
                dist[ny][nx] = dist[y][x] + 1;
                maxDist = max(maxDist, dist[ny][nx]);
                q.push({ ny, nx });
            }
        }
    }
    return maxDist;
}

void findTreasure() {
    int maxCnt = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (map[i][j]) {
                maxCnt = max(maxCnt, bfs(i, j));
            }
        }
    }
    cout << maxCnt << '\n';
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    init();
    findTreasure();

    return 0;
}
