#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int sum = 0;
int mSize = 0;
int pSize = 0;
bool zeroExist = false;
vector<int> minums;
vector<int> plnums;

void init() {
	cin >> n;
	int temp;
	for (int i = 0; i < n; ++i) {
		cin >> temp;
		if (temp == 0) {
			zeroExist = true;
		}
		else if (temp == 1) {
			++sum;
		}
		else if (temp > 1)
		{
			plnums.push_back(temp);
			++pSize;
		}
		else if (temp < 0)
		{
			minums.push_back(temp);
			++mSize;
		}
	}

	sort(minums.begin(), minums.end());
	sort(plnums.begin(), plnums.end(), greater<int>());
}

void cal()
{
	for (int i = 0; i < mSize; i += 2)
	{
		if (i + 1 < mSize)
		{
			sum += (minums[i] * minums[i + 1]);
		}
		else if (!zeroExist)
		{
			sum += minums[i];
		}
	}

	for (int i = 0; i < pSize; i += 2)
	{
		if (i + 1 < pSize)
		{
			sum += (plnums[i] * plnums[i + 1]);
		}
		else
		{
			sum += plnums[i];
		}
	}
}

int main()
{
	init();
	cal();
	cout << sum;
}