# bronze I

import sys

n = int(sys.stdin.readline())
str_arr = []

for _ in range(n):
    str_arr.append(sys.stdin.readline())

for i in range(len(str_arr)):
    str_arr[i] = str_arr[i].replace('\n', '')
    stack = str_arr[i].split(' ')
    print("Case #{}: ".format(i+1), end='')
    for j in range(len(stack)):
        print(stack.pop(), end=' ')
    print()
