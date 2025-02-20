#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

int n;

struct AntHole {
    map<string, AntHole*> antHols;

    void insert(vector<string>& tmpVec, int idx) {
        if (tmpVec.size() == idx) return;
        if (antHols.find(tmpVec[idx]) == antHols.end()) {
            antHols[tmpVec[idx]] = new AntHole();
        }
        antHols[tmpVec[idx]]->insert(tmpVec, idx + 1);
    }
};

AntHole* root = new AntHole();

void init() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int tmp = 0;
        cin >> tmp;
        vector<string> tmpVec(tmp);
        for (int j = 0; j < tmp; ++j) {
            cin >> tmpVec[j];
        }
        root->insert(tmpVec, 0);
    }
}

void printResult(AntHole* root, int d) {
    for (auto& antHole : root->antHols) {
        for (int i = 0; i < d; ++i) {
            cout << "--";
        }
        cout << antHole.first << "\n";
        printResult(antHole.second, d + 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    init();
    printResult(root, 0);
    return 0;
}
