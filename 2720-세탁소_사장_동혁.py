# bronze III

from sys import stdin

# input
T = int(stdin.readline().strip())
C = []
for _ in range(T):
    C.append(int(stdin.readline().strip()))

# 계산
for i in C:
    coin = list()

    coin.append(i//25)
    i %= 25
    coin.append(i//10)
    i %= 10
    coin.append(i // 5)
    i %= 5
    coin.append(i)

    for j in range(4):
        print(coin[j], end=' ')
    print()
