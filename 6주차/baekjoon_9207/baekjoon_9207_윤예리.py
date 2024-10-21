import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def sol(cnt):
    global pin_cnt, move_cnt

    # 핀 찾아서 위치 다 저장
    pins = []
    for i in range(5):
        for j in range(9):
            if arr[i][j] == 'o':
                pins.append((i, j))

    # 핀 줄어들었으면 답 갱신
    if len(pins) < pin_cnt:
        move_cnt = cnt
        pin_cnt = len(pins)

    # 탐색
    for x, y in pins:
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            nnx, nny = nx + dx[d], ny + dy[d]

            if 0 <= nnx < 5 and 0 <= nny < 9:
                if arr[nx][ny] == 'o' and arr[nnx][nny] == '.':
                    arr[nx][ny] = '.'
                    arr[nnx][nny] = 'o'
                    arr[x][y] = '.'
                    sol(cnt+1)
                    # 원래대로
                    arr[nx][ny] = 'o'
                    arr[nnx][nny] = '.'
                    arr[x][y] = 'o'

TC = int(input())
n = 101
for tc in range(TC):
    # 핀 최소 개수, 최소 이동 횟수
    pin_cnt, move_cnt = 100, 100
    arr = [list(input().strip()) for _ in range(5)]
    input()
    sol(0)
    print(pin_cnt, move_cnt)