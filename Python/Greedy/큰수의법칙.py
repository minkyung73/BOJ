from sys import stdin

n, m, k = map(int, stdin.readline().strip().split())
L = list(map(int, stdin.readline().strip().split()))
L = sorted(L)

total = 0

temp1 = m // k
temp2 = m % k

total += temp1 * k * L[-1]
total += temp2 * L[-2]

print(total)

