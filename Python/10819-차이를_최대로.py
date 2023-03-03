# silver II

from sys import stdin
from itertools import permutations

n = int(stdin.readline().strip())
arr = list(map(int, stdin.readline().strip().split(' ')))


def max_result(arr):
    result = 0
    # key point: 입력 받은 숫자들의 순열을 알면 쉽게 구할 수 있음
    per = list(permutations(arr, n))
    # print(per)

    for i in range(len(per)):
        sum = 0
        for j in range(len(per[i])-1):
            sum += abs(per[i][j]-per[i][j+1])

        if i == 1:
            result = sum
        else:
            if result < sum:
                result = sum

    return result


print(max_result(arr))
