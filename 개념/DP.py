import time

# 재귀
# def fibo(x):
#     if x == 1 or x == 2:
#         return 1
#
#     return fibo(x-1) + fibo(x-2)
#
# for num in range(5, 40, 10):
#     start = time.time()
#     res = fibo(num)
#     print(res, '-> 러닝타임:', round(time.time() - start, 2), '초')

# result
# 5 -> 러닝타임: 0.0 초
# 610 -> 러닝타임: 0.0 초
# 75025 -> 러닝타임: 0.02 초
# 9227465 -> 러닝타임: 1.99 초
# 재귀는 시간이 너무 오래 걸린다

# DP
d = [0] * 50    # 크기가 50인 배열을 0으로 초기화


def fibo(x):
    if x == 1 or x == 2:
        return 1

    if d[x] != 0:
        return d[x]

    d[x] = fibo(x-1) + fibo(x-2)
    return d[x]


for num in range(5, 40, 10):
    start = time.time()
    res = fibo(num)
    print(res, '-> 러닝타임:', round(time.time() - start, 2), '초')

