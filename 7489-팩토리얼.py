# bronze II

t = int(input())
n_list = []

for i in range(t):
    n_list.append(int(input()))

for i in range(len(n_list)):
    sum = 1
    for j in range(n_list[i], 0, -1):
        sum *= j
    n_list[i] = sum

for i in n_list:
    n_str = str(i)
    while n_str[-1] == '0':
        n_str = n_str[:len(n_str)-1]

    print(n_str[-1])
