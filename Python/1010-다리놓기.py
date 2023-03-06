# silver V
from sys import stdin

# input
t = int(stdin.readline())
bridge = []
for i in range(t):
    l, r = map(int, stdin.readline().split())
    bridge.append([l, r])


# l: 1개 / r: m개 -> m개
# l == r -> 1개
# l: n개 / r: m개 -> (n:m-1) + (n-1:m-1)
def bridge_f(l, r):
    dp = [[0 for _ in range(r+1)] for _ in range(l+1)]
    for i in range(1, l+1):
        for j in range(1, r+1):
            if i == 1:
                dp[i][j] = j
                continue
            if i == j:
                dp[i][j] = 1
            else:
                if j > i:
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1]
    return dp[l][r]


# function call & output
for l, r in bridge:
    print(bridge_f(l, r))
