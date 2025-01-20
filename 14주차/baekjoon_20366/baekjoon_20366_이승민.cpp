#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
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

    int min_diff = INT_MAX;

    for (int i = 0; i < n - 3; i++)
    {
        for (int j = n - 1; j > i + 2; j--)
        {
            int left = i + 1;
            int right = j - 1;
            while (left < right && right < j)
            {
                int sm1 = snows[i] + snows[j];
                int sm2 = snows[left] + snows[right];

                min_diff = min(min_diff, abs(sm1 - sm2));
                if (sm1 < sm2) right--;
                else if (sm1 == sm2) { cout << 0 << endl; return 0; }
                else left++;
            }
        }
    }
    cout << min_diff << endl;
    return 0;
}
