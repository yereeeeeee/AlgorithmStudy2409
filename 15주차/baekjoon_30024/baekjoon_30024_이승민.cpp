#include <iostream>
#include <vector>
#include <queue>
#include <sstream>

using namespace std;

struct Corn {
    int x, y, value;
    bool operator<(const Corn& other) const {
        return value < other.value;
    }
};

int n, m, k;
vector<vector<int>> corns;
vector<vector<bool>> harvested;
priority_queue<Corn> pq;
int dx[] = { -1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };

void init() {
    cin >> n >> m;
    corns.assign(n, vector<int>(m));
    harvested.assign(n, vector<bool>(m, false));

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> corns[i][j];

    cin >> k;

    for (int i = 0; i < n; i++) {
        pq.push({ i, 0, corns[i][0] });
        pq.push({ i, m - 1, corns[i][m - 1] });
    }
    for (int j = 0; j < m; j++) {
        pq.push({ 0, j, corns[0][j] });
        pq.push({ n - 1, j, corns[n - 1][j] });
    }
}

void harvest() {
    int total = 0;
    ostringstream oss;

    for (int i = 0; i < k; i++) {
        while (!pq.empty()) {
            Corn best = pq.top();
            pq.pop();

            if (harvested[best.x][best.y]) continue;

            harvested[best.x][best.y] = true;
            total += best.value;
            oss << best.x + 1 << " " << best.y + 1 << "\n";

            for (int d = 0; d < 4; d++) {
                int nx = best.x + dx[d];
                int ny = best.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !harvested[nx][ny]) {
                    pq.push({ nx, ny, corns[nx][ny] });
                }
            }

            break;
        }
    }

    cout << oss.str();
}

int main() {
    init();
    harvest();
    return 0;
}
