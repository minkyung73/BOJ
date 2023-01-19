# bronze I

from sys import stdin


def rev(num):
    r = str(num)[::-1]
    return int(r)


x, y = map(int, stdin.readline().split(' '))
print(rev(rev(x)+rev(y)))
