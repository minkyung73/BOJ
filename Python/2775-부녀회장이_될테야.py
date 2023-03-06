# bronze I
from sys import stdin

# input
t = int(stdin.readline())
arr = []
for i in range(t):
    k = int(stdin.readline())
    n = int(stdin.readline())
    arr.append([k, n])


# k층 n호
def fn(k, n):
    # apart initialize
    apart = []
    for i in range(k + 1):
        apart.append([])
    for i in range(n + 1):
        apart[0].append(i)

    # 계약조건
    for i in range(1, k+1):
        for j in range(n+1):
            if j == 0 or j == 1:
                apart[i].append(j)
            else:
                apart[i].append(apart[i][j-1] + apart[i-1][j])

    return apart[k][n]


# output
for k, n in arr:
    if n == 1:
        print(1)
    else:
        print(fn(k, n))

