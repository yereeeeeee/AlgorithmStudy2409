from collections import deque

arr = []
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
n, m = 0, 0


def bfs():
    q = deque([(0, 0)])
    visited = [[0] * m for _ in range(n)]
    visited[0][0] = 1

    while q:
        x, y = q.popleft()

        if (x == n - 1) and (y == m - 1):
            return visited[x][y]

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 1 and visited[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1

    return -1


def solution(maps):
    global n, m, arr
    arr = maps
    n = len(maps)
    m = len(maps[0])

    return bfs()
