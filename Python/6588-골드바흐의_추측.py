# silver I
from sys import stdin
import math

# input
num_list = []
while True:
    n = int(stdin.readline().strip())
    if n == 0:
        break
    num_list.append(n)
# 38
# 7 + 31
for num in num_list:
    # 골드바흐의 추측
    arr = []
    for i in range(3, num, 2):
        if arr:
            break
        a = i
        b = num - i
        if a > b:
            break
        # a=5 / b=33
        flag = True
        for j in range(3, int(math.sqrt(a)) + 1):
            if a != j and a % j == 0:
                flag = False
                break
        if not flag:
            continue

        flag = True
        for j in range(3, int(math.sqrt(b)) + 1):
            if b != j and b % j == 0:
                flag = False
                break
        if not flag:
            continue

        # 만약에 처음이라면
        if not arr:
            print(num, "=", a, "+", b)
            break
            # arr.append(a)
            # arr.append(b)
        # else:
        # # b-a가 더 큰 것을 대체시킴
        #     if arr[1] - arr[0] < b - a:
        #         arr[0] = a
        #         arr[1] = b

    # print(num, "=", arr[0], "+", arr[1])
    # 출력
    # 하나도 없는 경우
    # if len(arr) < 1:
    #     print("Goldbach's conjecture is wrong.")
    # # 하나인 경우
    # elif len(arr) == 1:
    #     print(num, "=", arr[0][0], "+", arr[0][1])
    # # 여러개인 경우
    # else:
    #     dif = [0] * (len(arr))
    #     for i in range(len(arr)):
    #         dif[i] = arr[i][1] - arr[i][0]
    #     idx = dif.index(max(dif))
    #     print(num, "=", arr[idx][0], "+", arr[idx][1])



