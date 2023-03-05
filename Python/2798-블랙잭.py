# bronze II

from sys import stdin

# input
n, m = map(int, stdin.readline().split())
arr = list(map(int, stdin.readline().split()))

# 3개의 조합 찾기 (재귀)
def comb(arr, n):
    combi_arr = []
    if n > len(arr):
        return combi_arr

    if n == 1:
        for i in arr:
            combi_arr.append([i])
    elif n > 1:
        for i in range(len(arr) - n + 1):
            for j in comb(arr[i+1:], n-1):
                combi_arr.append([arr[i]] + j)

    return combi_arr


# result 찾기
combi_arr = comb(arr, 3)
result = 0
for i in range(len(combi_arr)):
    temp = combi_arr[i][0] + combi_arr[i][1] + combi_arr[i][2]
    if temp <= m and (m-temp < m-result):
        result = temp

print(result)

