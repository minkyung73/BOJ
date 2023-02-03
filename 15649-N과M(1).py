# silver III

from sys import stdin
from itertools import permutations

n, m = map(int, stdin.readline().split())
arr = []
for i in range(1, n+1):
    arr.append(i)

per_list = list(permutations(arr, m))

for i in range(len(per_list)):
    for j in range(len(per_list[i])):
        print(per_list[i][j], end=' ')
    print()

