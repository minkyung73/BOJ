# silver IV

from sys import stdin

n = int(stdin.readline())
n_list = list(map(int, stdin.readline().split(' ')))
m = int(stdin.readline())
m_list = list(map(int, stdin.readline().split(' ')))
n_list.sort()


def binary_search(array, target):
    start = 0
    end = n-1

    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return target
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    return None


for i in m_list:
    if binary_search(n_list, i) is not None:
        print(1)
    else:
        print(0)

