def solution(m, n, startX, startY, balls):
    answer = []

    # 가다가 바로 타겟 공을 맞추는 경우가 있어서 그 경우를 빼줘야 함
    for x, y in balls:
        tmp = 10e10

        # 왼쪽 벽
        if not (startY == y and x < startX):
            tmp = min(abs(x + startX) ** 2 + abs(y - startY) ** 2, tmp)
        # 위쪽 벽
        if not (startX == x and y > startY):
            tmp = min(abs(x - startX) ** 2 + abs(2 * n - y - startY) ** 2, tmp)
        # 오른쪽 벽
        if not (startY == y and x > startX):
            tmp = min(abs(2 * m - startX - x) ** 2 + abs(y - startY) ** 2, tmp)
        # 아래쪽 벽
        if not (startX == x and y < startY):
            tmp = min(abs(x - startX) ** 2 + abs(y + startY) ** 2, tmp)
        answer.append(tmp)

    return answer