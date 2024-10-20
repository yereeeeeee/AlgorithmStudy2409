import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())
if n >= k:
    exit(print(0))

answer = 0
lst = deque(list(map(int, input().split())))
# 사용되는 횟수 count
cnt = {}
for i in range(k):
    if lst[i] in cnt:
        cnt[lst[i]] += 1
    else:
        cnt[lst[i]] = 1

multi = []
while lst:
    cur = lst.popleft() # 꽂아야 하는 플러그
    cnt[cur] -= 1
    # 이미 꽂혀 있으면 pass
    if cur in multi:
        continue
    # 멀티탭에 자리 있으면 꽂기
    if len(multi) < n:
        multi.append(cur)
        continue

    # 멀티탭에 빈 자리가 없으면
    answer += 1
    for i in range(n):
        tmp = multi[i]
        # 꽂혀 있는 것 중 이후 사용하지 않으면
        if cnt[tmp] == 0:
            multi[i] = cur
            break

    # 다 사용해야 되면 가장 나중에 사용하는 것을 뽑는다.
    else:
        idx = []
        for i in range(n):
            for j in range(len(lst)):
                if multi[i] == lst[j]:
                    idx.append(j)
                    break

        change = lst[max(idx)]
        multi[multi.index(change)] = cur

print(answer)
