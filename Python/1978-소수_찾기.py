# silver V
from sys import stdin

n = int(stdin.readline())
prime = list(map(int, stdin.readline().split()))

cnt = 0
for num in prime:
    if num < 2:
        continue
    flag = False
    for i in range(2, num):
        if num % i == 0:
            flag = True
            break
    if not flag:
        cnt += 1

print(cnt)

