#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

int r, c;
vector<pair<int, int>> waters;
vector<pair<int, int>> moves;
vector<string> forest;
int dx[] = { 0, 0, -1, 1 };
int dy[] = { -1, 1, 0, 0 };

bool inRange(int x, int y) {
    return x >= 0 && x < c && y >= 0 && y < r;
}

void flow() {
    vector<pair<int, int>> newWaters;
    for (auto water : waters) {
        for (int i = 0; i < 4; i++) {
            int nx = water.second + dx[i];
            int ny = water.first + dy[i];
            if (inRange(nx, ny) && forest[ny][nx] == '.') {
                forest[ny][nx] = '*';
                newWaters.push_back({ ny, nx });
            }
        }
    }
    waters.insert(waters.end(), newWaters.begin(), newWaters.end());
}

int go() {
    vector<pair<int, int>> newMoves;
    int dirs = 0;
    for (auto move : moves) {
        for (int i = 0; i < 4; i++) {
            int nx = move.second + dx[i];
            int ny = move.first + dy[i];
            if (inRange(nx, ny)) {
                if (forest[ny][nx] == '.') {
                    dirs++;
                    forest[ny][nx] = 'S';
                    newMoves.push_back({ ny, nx });
                }
                else if (forest[ny][nx] == 'D') {
                    return -1;
                }
            }
        }
    }
    moves = newMoves;
    return dirs;
}

int main() {
    cin >> r >> c;
    forest.resize(r);

    for (int i = 0; i < r; i++) {
        cin >> forest[i];
        for (int j = 0; j < c; j++) {
            if (forest[i][j] == 'S') {
                moves.push_back({ i, j });
            }
            else if (forest[i][j] == '*') {
                waters.push_back({ i, j });
            }
        }
    }

    int time = 1;
    while (time <= r * c) {
        flow();
        int can = go();
        if (can == 0) {
            cout << "KAKTUS" << endl;
            return 0;
        }
        else if (can == -1) {
            cout << time << endl;
            return 0;
        }
        time++;
    }

    cout << "KAKTUS" << endl;
    return 0;
}
