# silver II

from sys import stdin

N = int(stdin.readline())
arr = [[] for _ in range(N + 1)]

# 트리 생성
for i in range(N - 1):
    n1, n2, distance = map(int, input().split())
    arr[n1].append([n2, distance])
    arr[n2].append([n1, distance])

# [[], [[2, 3]], [[1, 3], [3, 2], [4, 4]], [[2, 2]], [[2, 4]]]
# print(arr)

visited = [0] * (N + 1)     # 0으로 초기화

# 스택
stack = [[1, 0]]    # arr index (방번호), distance
result = 0

# 연결된 트리를 기반으로 입구랑 가장 먼 방 찾기
while stack:
    v, distance = stack.pop()
    visited[v] = 1

    # [0, 1, 0, 0, 0]
    # [0, 1, 1, 0, 0]
    # [0, 1, 1, 0, 1]
    # [0, 1, 1, 1, 1]
    # print(visited)  # 방문한 인덱스는 1로 바꿔줌

    # leaf node 인지 판별
    flag = False

    # 현재 v 노드가 갈 수 있는 곳이 한곳이라도 있다면 leaf 노드가 아님
    for tmpv, tmpd in arr[v]:
        # tmpv: leafnode index
        # tmpd: leafnode와의 거리
        if visited[tmpv] == 0:  # 아직 방문하지 않은 곳
            flag = True

    # leaf node가 아닌 경우, 스택에 저장
    if flag == True:
        if arr[v]:
            print(arr[v])
            for nv, nd in arr[v]:
                if visited[nv] == 0:
                    stack.append([nv, distance + nd])
    # leaf node인 경우, 최대값을 갱신해 줍니다.
    else:
        if distance > result:
            result = distance

print(result)
