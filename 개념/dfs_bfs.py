from sys import stdin


def dfs(graph, start_node):
    need_visited, visited = list(), list()

    # 시작 노드
    need_visited.append(start_node)

    while need_visited:
        node = need_visited.pop()

        if node not in visited:
            visited.append(node)

            need_visited.extend(graph[node])
            # print(need_visited)

        # print(visited, "\n")

    return visited


def bfs(graph, start_node):
    need_visited = [start_node]
    visited = []

    while need_visited:
        # node = need_visited.pop(need_visited.index(0))
        node = need_visited[0]
        del need_visited[0]

        if node not in visited:
            visited.append(node)
            need_visited.extend(graph[node])

    return visited


graph = dict()

graph['A'] = ['B', 'C']
graph['B'] = ['A', 'D']
graph['C'] = ['A', 'G', 'H', 'I']
graph['D'] = ['B', 'E', 'F']
graph['E'] = ['D']
graph['F'] = ['D']
graph['G'] = ['C']
graph['H'] = ['C']
graph['I'] = ['C', 'J']
graph['J'] = ['I']

# print(dfs(graph, 'A'))
print(bfs(graph, 'A'))

# print(graph)
print(bfs(graph, 'B'))
