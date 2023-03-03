# silver III

from sys import stdin

n = int(stdin.readline().strip())
triangle = []
for i in range(n):
    triangle.append(int(stdin.readline().strip()))

triangle = sorted(triangle)

result = 0
flag = 0
for i in range(len(triangle)-2):
    if triangle[-1] < triangle[-2] + triangle[-3]:
        result = triangle[-1] + triangle[-2] + triangle[-3]
        flag = 1
        break
    else:
        triangle.pop()

if flag == 0:
    print("-1")
else:
    print(result)