# bronze II

from sys import stdin

a, b = map(int, stdin.readline().split(' '))

if a > b:
    temp = a
    a = b
    b = temp

# output 1
if a != b:
    print(b-a-1)
else:
    print("0")

# output 2
for i in range(a+1, b):
    print(i, end=' ')
