# bronze II

from sys import stdin
import math

# input
n = int(stdin.readline().strip())
num_list = []
for i in range(n):
    num_list.append(list(map(int, stdin.readline().split(' '))))

# output
for a, b in num_list:
    print(math.lcm(a, b), math.gcd(a, b))

