# silver V

# key point
# 굳이 스택으로 풀 필요가 없었다..
# 각 더미가 내림차순으로 정렬되어 있지 않으면 무조건 false이기 때문
# 스택으로 풀었을 땐 출력은 잘 나오지만 시간 초과

import sys

n, m = map(int, sys.stdin.readline().split())
order = True

for i in range(m):
    sys.stdin.readline()
    input_list = list(map(int, sys.stdin.readline().split()))
    if input_list != sorted(input_list, reverse=True):
        order = False
        break

if order:
    print("Yes")
else:
    print("No")
