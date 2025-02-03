#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> snows;

int main() {
    cin >> n;

    snows.resize(n);

    for (int i = 0; i < n; i++) {
        cin >> snows[i];
    }

    sort(snows.begin(), snows.end());

    for (int snow : snows) {
        cout << snow << " ";
    }
    cout << endl;

    return 0;
}
