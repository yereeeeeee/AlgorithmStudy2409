#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

using namespace std;

int n;
int mn = INT_MAX;
vector<int> lights;
vector<int> goal;
void toggle(vector<int>& lights, int idx)
{
    for (int i = idx - 1; i <= idx + 1; i++)
    {
        if (i >= 0 && i < lights.size())
            lights[i] = 1 - lights[i];
    }
}

void click(vector<int> lights, bool first)
{
    int cnt = 0;

    if (first)
    {
        toggle(lights, 0);
        ++cnt;
    }

    for (int i = 1; i < n; i++)
    {
        if (lights[i-1] != goal[i-1])
        {
            toggle(lights, i);
            ++cnt;
        }
    }
    if(lights == goal) mn = min(mn, cnt);
}
int main() {
    cin >> n;
    lights.resize(n);
    goal.resize(n);

    string input;

    cin >> input;
    for (int j = 0; j < n; j++)
        lights[j] = input[j] - '0';

    cin >> input;
    for (int j = 0; j < n; j++)
        goal[j] = input[j] - '0';

    click(lights, true);
    click(lights, false);
    if(mn == INT_MAX) cout << -1 << endl;
    else cout << mn << endl;
    return 0;
}
