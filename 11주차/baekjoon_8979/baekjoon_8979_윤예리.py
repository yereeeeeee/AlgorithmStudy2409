import sys

input = sys.stdin.readline

n, k = map(int, input().split())
arr = []

# 국가 정보 입력
for _ in range(n):
    num, gold, silver, bronze = map(int, input().split())
    arr.append((num, gold, silver, bronze))

# 메달 순위 정렬
arr.sort(key=lambda x: (-x[1], -x[2], -x[3]))

# 순위 계산
rank = {}
grade = 1

for i in range(n):
    if i > 0 and (arr[i][1:] == arr[i - 1][1:]):  # 메달 수가 동일하면 이전 국가와 동일 순위
        rank[arr[i][0]] = rank[arr[i - 1][0]]
    else:
        rank[arr[i][0]] = grade

    grade += 1

# 결과 출력
print(rank[k])
