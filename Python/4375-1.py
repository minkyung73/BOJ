# silver III
from sys import stdin

while True:
    try:
        n = int(stdin.readline().strip())
        str1 = '1'
        while True:
            if int(str1) % n == 0:
                print(len(str1))
                break
            else:
                str1 += '1'
    except:
        break


