import sys

input = sys.stdin.readline

n = int(input())
for _ in range(n):
    tmp = list(map(int, input().split()))
    T = tmp[0]
    print(T, end=' ')

    arr = tmp[1:]
    answer = 0
    heights = [arr[0]]

    for i in range(1, 20):  # 두 번째 학생부터 시작
        inserted = False

        for j in range(len(heights) - 1, -1, -1):
            if heights[j] < arr[i]:
                heights.insert(j + 1, arr[i])
                inserted = True
                break
            answer += 1

        if not inserted:
            heights.insert(0, arr[i])  # 제일 앞에 삽입

    print(answer)
