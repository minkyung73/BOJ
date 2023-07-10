# silver 5
# 수들의 합

from sys import stdin

S = int(stdin.readline().strip())

cnt = 0
total = 0
temp = 1

while total + temp <= S:
    total += temp
    temp += 1
    cnt += 1

print(cnt)
