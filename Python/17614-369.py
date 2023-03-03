# bronze III

from sys import stdin

n = int(stdin.readline().strip())
cnt = 0

for i in range(1, n+1):
    cnt += str(i).count('3')
    cnt += str(i).count('6')
    cnt += str(i).count('9')

print(cnt)
