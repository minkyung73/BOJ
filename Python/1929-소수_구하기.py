# silver III
from sys import stdin
import math

m, n = map(int, stdin.readline().split())

for num in range(m, n+1):
    if num == 1 or (num != 2 and num % 2 == 0):
        continue
    flag = True
    for i in range(2, int(math.sqrt(num))+1):
        if num % i == 0:
            flag = False
            break
    if flag:
        print(num)
        
