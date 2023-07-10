# silver 5
# 뒤집기

from sys import stdin

S = stdin.readline().strip()

cnt0 = 0
cnt1 = 0

pre = ''
for i in range(len(S)):
    if i == 0:
        pre = i
        continue

    if S[i] != S[i-1]:
        pre = i
        if S[i-1] == '0':
            cnt0 += 1
        else:
            cnt1 += 1

    if i == len(S) - 1:
        if S[i] == '0':
            cnt0 += 1
        else:
            cnt1 += 1

print(min(cnt0, cnt1))

