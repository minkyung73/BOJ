from sys import stdin

# input
n = int(stdin.readline().strip())
num = []
for i in range(n):
    num.append(int(stdin.readline().strip()))


# 재귀
def f123(number):
    if number == 1:
        return 1
    elif number == 2:
        return 2
    elif number == 3:
        return 4
    else:
        return f123(number-1) + f123(number-2) + f123(number-3)


for i in num:
    print(f123(i))

