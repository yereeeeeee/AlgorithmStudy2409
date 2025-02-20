#include <iostream>
#include <string>
#include <vector>

using namespace std;

string s;
string p;

void init()
{
	cin >> s >> p;
}

int makeP()
{
	int cnt = 1;
	string temp = string(1, p[0]);
	for (int i = 1; i < p.length(); i++)
	{
		if (temp.length() <= s.length() && s.find(temp + p[i]) != string::npos)
		{
			temp += p[i];
		}
		else
		{
			temp = p[i];
			++cnt;
		}
	}
	return cnt;
}
int main()
{
	init();
	cout << makeP();
}
