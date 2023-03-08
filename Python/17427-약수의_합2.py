# silver II
from sys import stdin
import math

n = int(stdin.readline())

total = 0
for i in range(1, n+1):
    total += (n//i)*i

print(total)



