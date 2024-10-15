from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def solution(rectangle, characterX, characterY, itemX, itemY):
    # ㄷ자 처럼 좌표가 1 차이나면 바로 가버릴 수 있으므로 2배 해줘서 계산
    graph = [[-1] * 102 for _ in range(102)] # 사각형 2배 해줄 예정이라 범위는 102
    for rect in rectangle:
        x1, x2, y1, y2 = map(lambda x: x*2, rect)
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                # 사각형 안 쪽은 0으로
                if x1 < i < x2 and y1 < j < y2:
                    graph[i][j] = 0
                elif graph[i][j] != 0:
                    # 모서리는 1
                    graph[i][j] = 1


    q = deque([characterX * 2, characterY * 2])
    visited = [[0] * 102 for _ in range(102)]
    visited[characterX * 2][characterY * 2] = 1

    while q:
        x, y = q.popleft()
        if x == itemX*2 and y == itemY*2:
            return(visited[x][y] // 2)

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if graph[nx][ny] and not visited[nx][ny]:
                q.append([nx, ny])
                visited[nx][ny] = visited[x][y] + 1

    return -1