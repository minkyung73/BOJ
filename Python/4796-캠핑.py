# bronze I

from sys import stdin

# input
i = 0
arr = []
while True:
    l, p, v = map(int, stdin.readline().strip().split(' '))

    if l == 0 and p == 0 and v == 0:
        break

    arr.append([])
    arr[i].append(l)
    arr[i].append(p)
    arr[i].append(v)
    i += 1

# 계산
for i in range(len(arr)):
    day = 0

    while arr[i][2] > 0:
        if arr[i][2] > arr[i][0]:
            day += arr[i][0]
            arr[i][2] -= arr[i][1]
        else:
            day += arr[i][2]
            break

    i += 1

    print("Case {}: {}".format(i, day))



