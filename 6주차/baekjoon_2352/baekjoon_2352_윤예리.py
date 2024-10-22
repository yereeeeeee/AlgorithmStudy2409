import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))


dp = [40001] * (n+1)
dp[0] = 0
dp[1] = arr[0]
answer = 1

for i in range(1, n):
    start, end = 0, answer
    cnt = 0

    while start <= end:
        mid = (start + end) // 2

        if dp[mid] > arr[i]:
            end = mid - 1
        elif dp[mid] < arr[i]:
            start = mid + 1
            cnt = mid + 1

    dp[cnt] = arr[i]
    answer = max(answer, cnt)

print(answer)
print(dp)