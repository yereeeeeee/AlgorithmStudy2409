#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Work {
    int d, w;

    bool operator<(const Work& work) const {
        if (d != work.d) return d > work.d;
        return w < work.w;
    }
};

int n;
// priority_queue<T, Container, Compare>
priority_queue<int, vector<int>, greater<int>> done;
priority_queue<Work> works;

void init()
{
    cin >> n;
    int d, w;
    for (int i = 0; i < n; i++) {
        cin >> d >> w;
        works.push({ d, w });
    }
}

void doWorks()
{
    while (!works.empty()) {
        Work work = works.top();
        works.pop();

        if (done.size() < work.d) {
            done.push(work.w);
        }
        else if (!done.empty() && done.top() < work.w) {
            done.pop();
            done.push(work.w);
        }
    }
    int sum = 0;
    while (!done.empty()) {
        sum += done.top();
        done.pop();
    }

    cout << sum << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    init();
    doWorks();

    return 0;
}
