# bronze I
from sys import stdin

num = int(stdin.readline()) # 약수의 개수
arr = list(map(int, stdin.readline().split()))
arr.sort()
print(arr[0]*arr[-1])


