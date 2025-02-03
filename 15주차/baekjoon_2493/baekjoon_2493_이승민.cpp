#include <iostream>
#include <vector>
#include <stack>
#include <sstream>

using namespace std;
int n;
vector<int> tops;
ostringstream oss;
vector<int> connections;
stack<pair<int, int>> s; 
void init()
{
    cin >> n;
    tops.resize(n);
    connections.resize(n);
}

void connect()
{
    for (int i = 0; i < n; i++) {
        cin >> tops[i];

        while (!s.empty() && s.top().second < tops[i]) s.pop();
        
        if (!s.empty()) oss << s.top().first + 1 << " ";
        else oss << "0 ";

        s.push({i, tops[i]});
    }

    cout << oss.str();
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    init();
    connect();
    return 0;
}
