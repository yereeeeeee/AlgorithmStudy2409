#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int n, m, k;
vector<vector<int>> boardSum;
vector<vector<bool>> board;

void init() {
	cin >> n >> m >> k;
	board.resize(n, vector<bool>(m));

	string input;
	// W = true, B = false
	for (int i = 0; i < n; ++i) {
		cin >> input;
		for (int j = 0; j < m; ++j) {
			board[i][j] = (input[j] == 'W');
		}
	}

	boardSum.resize(n + 1, vector<int>(m + 1, 0));

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			bool expected = ((i + j) % 2 == 0);  // W 시작 예상 값
			boardSum[i][j] = boardSum[i - 1][j] + boardSum[i][j - 1] - boardSum[i - 1][j - 1] + (board[i - 1][j - 1] != expected);
		}
	}
}

int getSum(const vector<vector<int>> &sumArray, int x1, int y1, int x2, int y2) {
	return sumArray[x2][y2] - sumArray[x1 - 1][y2] - sumArray[x2][y1 - 1] + sumArray[x1 - 1][y1 - 1];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	init();
	int res = k * k + 1;

	for (int i = 1; i <= n - k + 1; ++i) {
		for (int j = 1; j <= m - k + 1; ++j) {
			int sum1 = getSum(boardSum, i, j, i + k - 1, j + k - 1);
			int sum2 = k * k - sum1;
			res = min(res, min(sum1, sum2));
		}
	}

	cout << res;
	return 0;
}
