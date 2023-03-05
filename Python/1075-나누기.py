# bronze II

from sys import stdin

n = stdin.readline()
f = int(stdin.readline())

lastDigit2 = int(n[-3:])

for i in range(100):
    temp = int(n[:-3]) * 100 + i
    if temp % f == 0:
        if i<10:
            print('0{}'.format(i))
        else:
            print(i)
        break
