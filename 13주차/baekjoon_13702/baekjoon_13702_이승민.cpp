#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n; // 주전자 수
int k; // 사람 수
vector<int> volumes;
long long binary(long long);

int main()
{
    cin >> n >> k;
    volumes.resize(n);

    long long mn = 1;
    long long mx = 0;

    for (int i = 0; i < n; i++)
    {
        cin >> volumes[i];
        mx = max(mx, (long long)volumes[i]); 
    }

    while (mn <= mx)
    {
        long long md = (mn + mx) / 2;
        if (binary(md) >= k)
        {
            mn = md + 1;
        }
        else
        {
            mx = md - 1;
        }
    }
    cout << mx;

    return 0;
}

long long binary(long long v)
{
    long long people = 0;
    for (int i = 0; i < n; i++)
    {
        people += volumes[i] / v;
        if (people >= k) 
            return people;
    }
    return people;
}
