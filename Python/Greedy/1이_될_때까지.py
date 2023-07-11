from sys import stdin

n, k = map(int, stdin.readline().strip().split())

cnt = 0

while n != 1:
    cnt += 1
    if n % k == 0 and k != 1:
        n //= k
    else:
        n -= 1

print(cnt)

