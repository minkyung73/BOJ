# silver V
from sys import stdin

# input
n = int(stdin.readline())

# 각 타일 변의 길이
arr = []
for i in range(n+1):
    if i == 0 or i == 1:
        arr.append(1)
    else:
        arr.append(arr[i-1] + arr[i-2])

# 직사각형 둘레
print(2*(arr[n-1] + arr[n]))
