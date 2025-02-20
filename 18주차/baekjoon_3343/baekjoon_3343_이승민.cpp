#include <iostream>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

typedef long long ll;

int main() {
    ll N, A, B, C, D;
    cin >> N >> A >> B >> C >> D;

    if (B * C < D * A) {
        swap(A, C);
        swap(B, D);
    }

    ll min_cost = LLONG_MAX;

    for (ll i = 0; i < C; ++i) {
        ll remaining = N - i * A;
        ll cost = i * B;

        if (remaining > 0) {
            cost += ((remaining + C - 1) / C) * D;
        }

        min_cost = min(min_cost, cost);
    }

    cout << min_cost << endl;

    return 0;
}
