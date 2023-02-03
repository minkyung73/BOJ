# bronze I
# Python3로 제출하면 시간초과 떠서 pypy로 제출

from sys import stdin


def recur_fibo(n):
    if n == 1 or n == 2:
        return 1
    else:
        return recur_fibo(n - 1) + recur_fibo(n - 2)

def dp_fibo(n):
    d = [0] * (n+1)
    dp_cnt = 0

    if n == 1 or n == 2:
        d[n] = 1

    for i in range(3, n+1):
        dp_cnt += 1
        d[i] = d[i-1] + d[i-2]

    return dp_cnt


n = int(stdin.readline().strip())
print(recur_fibo(n), dp_fibo(n))

# import time
#
# start = time.time()
# result = recur_fibo(n)
# print(result, round(time.time() - start, 2))
# start = time.time()
# result = dp_fibo(n)
# print(result, round(time.time() - start, 2))
