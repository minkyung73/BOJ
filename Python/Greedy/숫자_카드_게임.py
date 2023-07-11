from sys import stdin

row, col = map(int, stdin.readline().strip().split())

L = []
minL = []
for i in range(row):
    l = list(map(int, stdin.readline().strip().split()))
    L.append(l)
    minL.append(min(l))

print(max(minL))


