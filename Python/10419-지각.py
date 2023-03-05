# bronze III

from sys import stdin

# input
n = int(stdin.readline())
arr = []
for i in range(n):
    arr.append(int(stdin.readline()))

# bruteforce
late = []
for i in arr:
    max_late = 0
    for j in range(i):
        s = pow(j, 2)
        if s + j <= i and max_late < j:
            max_late = j
    late.append(max_late)

# output
for i in late:
    print(i)
