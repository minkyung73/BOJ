# silver II
from sys import stdin

n = int(stdin.readline())
arr = [0] * (n+1)


def f(x):
    f_total = 0
    for i in range(1, x//2):
        if x % i == 0:
            f_total += i
    f_total += x

    arr[x] = f_total
    # return f_total


def g(x):
    g_total = 0
    for i in range(x):
        g_total += arr[i]

    return g_total


print(g(n))
# result = 0
# for i in arr:
#     result += i
# # print(g(n))
# print(result)

