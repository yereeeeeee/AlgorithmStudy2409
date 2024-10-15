def solution(diffs, times, limit):
    max_level = max(diffs)
    n = len(diffs)
    start = 1
    end = max_level
    answer = max_level

    while start < end:
        mid = (start + end) // 2
        time = times[0]

        for i in range(1, n):
            k = 0
            if mid < diffs[i]:
                k = diffs[i] - mid
            time += (times[i] + times[i-1]) * k + times[i]

        if time <= limit:
            end = mid
            answer = mid
        else:
            start = mid + 1

    return answer


print(solution([1, 5, 3], [2, 4, 7], 30, 3))