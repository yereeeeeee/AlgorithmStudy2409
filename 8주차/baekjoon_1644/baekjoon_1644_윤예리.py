n = int(input())

def is_Prime(x):
    if x < 2:
        return False
    for i in range(2, int(x ** 0.5) + 1):
        if not x % i:
            return False
    return True

arr = []
for i in range(n + 1):
    if is_Prime(i):
        arr.append(i)

if not arr:
    exit(print(0))

start, end = 0, 0
total = arr[start]
answer = 0
while start <= end:

    if total == n:
        answer += 1
        total -= arr[start]
        start += 1
        continue

    elif total > n:
        total -= arr[start]
        start += 1

    else:
        end += 1
        if end == len(arr):
            break
        total += arr[end]

print(answer)