# bronze V
from sys import stdin

a, b, c = map(int, stdin.readline().split())

print((a+b) % c)
print(((a % c)+(b % c)) % c)
print((a*b) % c)
print(((a % c)*(b % c)) % c)
