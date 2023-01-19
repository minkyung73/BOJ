# bronze II

# 시간 초과
# 입력 받을 때 input()이 시간을 많이 잡아먹음

import sys

n = int(sys.stdin.readline())
stack = []
result = 1

for i in range(n):
    stack.append(int(sys.stdin.readline()))

last_num = stack[-1]
for i in reversed(stack):
    if i > last_num:
        result += 1
        last_num = i

print(result)
