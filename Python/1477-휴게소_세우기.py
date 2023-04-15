from sys import stdin
#
n, m, l = map(int, stdin.readline().split(' '))
restArea = list(map(int, stdin.readline().split(' ')))
restArea.append(0)
restArea.append(l)
# restArea.sort()
restArea = sorted(restArea)

# print(n, m, l)
# print(restArea)

left = 1
right = l-1

# result = 0

while left <= right:
    count = 0
    mid = (right + left) // 2

    for i in range(1, len(restArea)):
        if restArea[i] - restArea[i-1] > mid:
            count += (restArea[i] - restArea[i-1] - 1) // mid

    # left, right 바꿔주기
    if count > m:
        # mid는 더 길어야 한다
        left = mid + 1
    else:
        # mid는 더 짧아야 한다
        right = mid - 1
        result = mid

print(result)

