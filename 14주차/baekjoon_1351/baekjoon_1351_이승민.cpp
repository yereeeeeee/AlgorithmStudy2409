#include <iostream>
#include <unordered_map>

using namespace std;

long long n, p, q;
unordered_map<long long, long long> seq_map;

long long seq(long long n);

int main() {
    cin >> n >> p >> q;

    seq_map[0] = 1;

    cout << seq(n) << endl;

    return 0;
}

long long seq(long long n) {
    if (seq_map.find(n) != seq_map.end()) {
        return seq_map[n];
    }

    seq_map[n] = seq(n / p) + seq(n / q);

    return seq_map[n];
}
