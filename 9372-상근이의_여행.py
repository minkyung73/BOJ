# silver IV

from sys import stdin

t = int(stdin.readline())
t_list = []

for i in range(t):
    a, b = map(int, stdin.readline().split(' '))
    t_list.append([])
    for j in range(b):
        t_list[i].append(list(map(int, stdin.readline().split(' '))))

    print(a-1)

