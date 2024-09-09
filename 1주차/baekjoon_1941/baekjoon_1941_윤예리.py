import sys
input = sys.stdin.readline
from itertools import combinations
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def check(lst):
    global answer
    x, y = lst.pop(0)
    visited = [[0] * 5 for _ in range(5)]
    visited[x][y] = 1

    if arr[x][y] == 'S': value = 1
    else: value = 0

    q = deque([(x, y)])
    total = 1

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < 5 and 0 <= ny < 5:
                if (nx, ny) in lst and not visited[nx][ny]:
                    total += 1
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                    if arr[nx][ny] == 'S':
                        value += 1

    if total == 7 and value >= 4:
        answer += 1

arr = [list(input()) for _ in range(5)]
tmp = [i for i in range(25)]
cand = list(combinations(tmp, 7))
answer = 0
for c in cand:
    lst = []
    for i in c:
        x = i//5
        y = i%5
        lst.append((x, y))

    check(lst)
print(answer)