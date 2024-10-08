def find(num):
    divisors = [0] * (num+1)
    for i in range(1, int(num ** 0.5)+1):
        divisors[i*i] += 1
        for j in range(i * (i+1), num+1, i):
            divisors[j] += 2

    return divisors

def solution(e, starts):
    answer = []

    divisor_cnt = find(e)

    freq = [0] * (e+1)
    max_num = e

    for i in range(e, 0, -1):
        if divisor_cnt[i] >= divisor_cnt[max_num]:
            max_num = i

        freq[i] = max_num

    return [freq[s] for s in starts]