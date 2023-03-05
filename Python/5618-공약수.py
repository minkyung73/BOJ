# bronze II
import math
from sys import stdin
from math import gcd

n = int(stdin.readline())

if n == 2:
    a, b = map(int, stdin.readline().split())
    gcd_result = gcd(a, b)
else:
    a, b, c = map(int, stdin.readline().split())
    gcd_result = gcd(gcd(a, b), c)

result = [1]
for i in range(2, gcd_result//2 + 1):
    if gcd_result % i == 0:
        result.append(i)
result.append(gcd_result)

for i in result:
    print(i)
