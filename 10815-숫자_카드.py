# silver V

from sys import stdin

# input
n = int(stdin.readline().strip())
n_list = list(map(int, stdin.readline().split(' ')))
m = int(stdin.readline().strip())
m_list = list(map(int, stdin.readline().split(' ')))

n_list.sort()


def binary_search(arr, target):
    start = 0
    end = n-1

    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

    return None


for i in range(m):
    if binary_search(n_list, m_list[i]) is not None:
        print(1, end=' ')
    else:
        print(0, end=' ')



