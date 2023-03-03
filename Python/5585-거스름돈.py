# bronze II

from sys import stdin

change = 1000 - int(stdin.readline())
sum = 0

sum += change//500
change %= 500
sum += change//100
change %= 100
sum += change//50
change %= 50
sum += change//10
change %= 10
sum += change//5
change %= 5
sum += change//1
change %= 1

print(sum)
